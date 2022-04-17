package com.zjl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjl.model.domain.User;
import com.zjl.service.UserService;
import com.zjl.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.zjl.constant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户服务
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;

    private static final String salt = "2022";


    @Override
    public long userRegister(String userAccount, String userPassword, String checkPasswords) {
        // 1, 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPasswords)){
            // 修改为自定义异常
            return -1;
        }
        if (userAccount.length() < 4){
            return -1;
        }
        if (userPassword.length() < 8 || checkPasswords.length() < 8){
            return -1;
        }
        //// 账户不能重复（查库）
        //QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper.eq("userAccount", userAccount);
        //long count = this.count(queryWrapper);
        //if (count > 0){
        //    return -1;
        //}

        // 账户不包含特殊字符
        //必须是6-10位字母、数字、下划线（这里字母、数字、下划线是指任意组合，没有必须三类均包含）不能以数字开头
        //https://www.jb51.net/article/169453.htm
        String validPatter = "^[^0-9][\\w_]{5,9}$";
        Matcher matcher = Pattern.compile(validPatter).matcher(userAccount);
        if (! matcher.find()){
            return -1;
        }

        // 密码和校验密码要相同
        if (!userPassword.equals(checkPasswords)){
            return -1;
        }

        //-------------------------这里要查库，放在最后。如果前面提前返回，可以实现优化（减少资源占用）。
        // 账户不能重复（查库）
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        //long count = this.count(queryWrapper);
        Long count = userMapper.selectCount(queryWrapper);
        if (count > 0){
            return -1;
        }


        // 2, 加密
        // 112f8f44fe99ac3cdbc6dc268d5f2dc0

        String encryptPassword = DigestUtils.md5DigestAsHex((salt + userPassword).getBytes());
        // 3, 入库数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        //这里直接用service的方法
        boolean b = this.save(user);
        if (!b){
            return -1;
        }
        return user.getId();
    }

    @Override
    public User userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        // 1, 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)){
            return null;
        }
        if (userAccount.length() < 4){
            return null;
        }
        if (userPassword.length() < 8){
            return null;
        }

        // 账户不包含特殊字符
        //必须是6-10位字母、数字、下划线（这里字母、数字、下划线是指任意组合，没有必须三类均包含）不能以数字开头
        //https://www.jb51.net/article/169453.htm
        String validPatter = "^[^0-9][\\w_]{5,9}$";
        Matcher matcher = Pattern.compile(validPatter).matcher(userAccount);
        if (! matcher.find()){
            return null;
        }
        // 2, 加密
        String encryptPassword = DigestUtils.md5DigestAsHex((salt + userPassword).getBytes());
        // 查库判断用户是否存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        queryWrapper.eq("userPassword", encryptPassword);
        User user = userMapper.selectOne(queryWrapper);
        // 用户不存在
        if (user == null){
            log.info("user login failed, userAccount cannot match userPassword");
            return null;
        }

        // 3, 用户脱敏（新生成一个对象，只设置允许返回给前端的值）
        User safetyUser = getSafetyUser(user);

        // 4, 记录用户的登录态
        request.getSession().setAttribute(USER_LOGIN_STATE,user);
        // 返回脱敏后的用户信息
        return safetyUser;
    }


    /**
     * @description 用户脱敏
     * @author Lemonade
     * @param: originalUser
     * @updateTime 2022/3/27 下午3:36
     * @return: com.zjl.model.domain.User
     */
    public User getSafetyUser(User originalUser) {
        User safetyUser = new User();
        safetyUser.setId(originalUser.getId());
        safetyUser.setUsername(originalUser.getUsername());
        safetyUser.setUserAccount(originalUser.getUserAccount());
        safetyUser.setAvatarUrl(originalUser.getAvatarUrl());
        safetyUser.setGender((originalUser.getGender()));
        safetyUser.setPhone(originalUser.getPhone());
        safetyUser.setEmail(originalUser.getEmail());
        safetyUser.setUserStatus(originalUser.getUserStatus());
        safetyUser.setCreateTime(originalUser.getCreateTime());
        safetyUser.setUserRole(originalUser.getUserRole());

        return safetyUser;
    }

}




