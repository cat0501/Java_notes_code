package com.zjl.service;

import com.zjl.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户服务
 */
public interface UserService extends IService<User> {

    //String USER_LOGIN_STATE = "userLoginState";

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

     /**
      * @description 返回脱敏后的用户信息
      * @author Lemonade
      * @param: userAccount
      * @param: userPassword
      * @updateTime 2022/3/27 上午9:51
      * @return: com.zjl.model.domain.User
      */
     // 往请求的session中设置值，从请求的session中取出值
     User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originalUser
     * @return
     */
    public User getSafetyUser(User originalUser);
}
