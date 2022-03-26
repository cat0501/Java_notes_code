package com.hmdp.utils;

import com.hmdp.dto.UserDTO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author cat
 * @description
 * @date 2022/3/13 上午9:39
 */
public class LoginInterceptor2 implements HandlerInterceptor {
    /**
     * @description 前置拦截
     * @author Lemonade
     * @param: request
     * @param: response
     * @param: handler
     * @updateTime 2022/3/13 上午9:45
     * @return: boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1,获取Session
        HttpSession session = request.getSession();
        // 2,获取Session中的用户
        Object user = session.getAttribute("user");
        // 3,判断用户是否存在
        if (user == null){
            // 4,不存在，拦截，返回401状态码
            response.setStatus(401);
            return false;
        }
        // 5,存在，保存用户信息到ThreadLocal  (ThreadLocal的实现原理可以自己下来学习下)
        UserHolder.saveUser((UserDTO) user);
        // 6,放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 移除用户
        UserHolder.removeUser();
    }
}
