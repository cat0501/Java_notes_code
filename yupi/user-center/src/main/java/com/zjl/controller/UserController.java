package com.zjl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjl.constant.UserConstant;
import com.zjl.model.domain.User;
import com.zjl.model.request.UserLoginRequest;
import com.zjl.model.request.UserRegisterRequest;
import com.zjl.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cat
 * @description 用户控制器
 * @date 2022/3/27 上午10:51
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Long userRegister(@RequestBody UserRegisterRequest userRegisterRequest){
        if (userRegisterRequest == null){
            return null;
        }

        // Controller层倾向于对请求参数本身的校验，不涉及业务逻辑本身。
        // Service层是对业务逻辑的校验（有可能被Controller之外的类调用）
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPasswords = userRegisterRequest.getCheckPasswords();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPasswords)){
            return null;
        }

        return userService.userRegister(userAccount, userPassword, checkPasswords);
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request){
        if (userLoginRequest == null){
            return null;
        }

        // Controller层倾向于对请求参数本身的校验，不涉及业务逻辑本身。
        // Service层是对业务逻辑的校验（有可能被Controller之外的类调用）
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)){
            return null;
        }

        return userService.userLogin(userAccount, userPassword, request);
    }


    @GetMapping("/search")
    public List<User> searchUsers(String username, HttpServletRequest request){
        //// 鉴权：仅管理员可查询
        //Object userObj = request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
        //User user = (User) userObj;
        //if (user == null || user.getRole() == UserConstant.ADMIN_ROLE){
        //    return new ArrayList<>();
        //}

        if (!isAdmin(request)){
            return new ArrayList<>();
        }

        //if (!StringUtils.isNotBlank(username)){
        //    return null;
        //}

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 默认左右模糊查询
        if (StringUtils.isNotBlank(username)){
            queryWrapper.like("username", username);
        }
        //queryWrapper.likeLeft("username", username);
        List<User> userList = userService.list(queryWrapper);
        return userList.stream().map(user -> {
            user.setUserPassword(null);
            return userService.getSafetyUser(user);
            //return user;
        }).collect(Collectors.toList());
    }


    // 这里，我们看下mbp的官方文档：https://baomidou.com/pages/6b03c5/
    // 逻辑删除是为了方便数据恢复和保护数据本身价值等等的一种方案，但实际就是删除。
    // 如果你需要频繁查出来看就不应使用逻辑删除，而是以一个状态去表示。

    //插入: 不作限制
    //查找: 追加 where 条件过滤掉已删除数据,且使用 wrapper.entity 生成的 where 条件会忽略该字段
    //更新: 追加 where 条件防止更新到已删除数据,且使用 wrapper.entity 生成的 where 条件会忽略该字段
    //删除: 转变为 更新
    @PostMapping("/delete")
    public boolean deleteUsers(@RequestBody long id, HttpServletRequest request){
        //// 鉴权：仅管理员可查询
        //Object userObj = request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
        //User user = (User) userObj;
        //if (user == null || user.getRole() == UserConstant.ADMIN_ROLE){
        //    return false;
        //}

       if (!isAdmin(request)){
           return false;
       }

        if (id <= 0) {
            return false;
        }

        return userService.removeById(id);
    }


    /**
     * @description 是否为管理员
     * @author Lemonade
     * @param: request
     * @updateTime 2022/3/27 下午2:33
     * @return: boolean
     */
    private boolean isAdmin(HttpServletRequest request){
        // 鉴权：仅管理员可查询
        Object userObj = request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
        User user = (User) userObj;
        return user != null && user.getUserRole() == UserConstant.ADMIN_ROLE;
    }

}
