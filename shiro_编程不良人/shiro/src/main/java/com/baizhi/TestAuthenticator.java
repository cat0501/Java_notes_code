package com.baizhi;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

/**
 shiro第一个程序：用户认证
 */
public class TestAuthenticator {
    public static void main(String[] args) {

        //1.创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        //2.给安全管理器设置realm
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));

        //3.SecurityUtils 给全局安全工具类设置安全管理器
        // 对全部的subject进行安全管理，它是shiro的核心，负责对所有的subject进行安全管理。
        // 实质上SecurityManager是通过Authenticator进行认证，通过Authorizer进行授权，通过SessionManager进行会话管理等。
        SecurityUtils.setSecurityManager(securityManager);

        //4.关键对象 subject 主体
        Subject subject = SecurityUtils.getSubject();

        //5.创建令牌
        UsernamePasswordToken token = new UsernamePasswordToken("xiaochen","123");
        // 认证通过没有任何异常，否则抛出相应的异常
        try{
            System.out.println("认证状态: "+ subject.isAuthenticated());
            subject.login(token);//用户认证
            System.out.println("认证状态: "+ subject.isAuthenticated());
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("认证失败: 用户名不存在~");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("认证失败: 密码错误~");
        }

    }
}
