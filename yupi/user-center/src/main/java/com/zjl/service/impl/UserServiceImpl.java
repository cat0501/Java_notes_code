package com.zjl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjl.model.domain.User;
import com.zjl.service.UserService;
import com.zjl.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用户服务
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPasswords) {
        // 1, 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPasswords)){
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
        final String salt = "2022";
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
}




