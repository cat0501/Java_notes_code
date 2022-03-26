package com.zjl.service;

import com.zjl.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户服务
 */
public interface UserService extends IService<User> {

    /**
     * @description 用户注册
     * @author Lemonade
     * @param: userAccount
     * @param: userPassword
     * @param: checkPasswords
     * @updateTime 2022/3/26 下午10:02
     * @return: 新用户id
     */
     long userRegister(String userAccount, String userPassword, String checkPasswords);
}
