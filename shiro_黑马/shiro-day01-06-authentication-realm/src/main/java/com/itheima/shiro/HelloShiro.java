package com.itheima.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @Description：shiro的第一个例子
 */
public class HelloShiro {

    /**
     * 校验角色api:
     * subject.hasRole("admin");
     * subject.checkRole("coder");
     *
     * 校验权限api:
     * subject.isPermitted("order:list");
     * subject.checkPermission("order:update");
     */
    @Test
    public void testPermissionRealm(){
        Subject subject = shiroLogin();
        //打印登录信息
        System.out.println("登录结果:"+subject.isAuthenticated());
        //-------校验当前用户是否拥有管理员的角色
        System.out.println("是否有管理员角色"+subject.hasRole("admin"));
        //-------校验当前用户没有的角色
        try {
            subject.checkRole("coder");
            System.out.println("当前用户有coder角色");
        }catch (Exception ex){
            System.out.println("当前用户没有coder角色");
        }
        //-------校验当前用户的权限信息
        System.out.println("是否有查看订单的权限"+subject.isPermitted("order:list"));
        //-------校验当前用户没有的权限
        try {
            subject.checkPermission("order:update");
            System.out.println("当前用户有修改的权限");
        }catch (Exception ex){
            System.out.println("当前用户没有修改的权限");
        }
    }
    // 输出如下：-------------------------------------------
    //登录结果:true
    //是否有管理员角色true
    //当前用户没有coder角色
    //是否有查看订单的权限true
    //当前用户没有修改的权限


    // 登陆成功后，返回给我们 subject
    public Subject shiroLogin(){
        //导入INI配置创建工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //工厂构建安全管理器
        SecurityManager securityManager = factory.getInstance();
        //使用工具生效安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        //使用工具获得subject主体
        Subject subject = SecurityUtils.getSubject();
        //构建账户密码
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("jay","123");
        //使用subject主体去登录
        subject.login(usernamePasswordToken);

        return subject;
    }

}
