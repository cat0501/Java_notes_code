package com.itheima.shiro.realm;

import com.itheima.shiro.service.SecurityService;
import com.itheima.shiro.service.impl.SecurityServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Description：自定义Realm
 */
public class DefinitionRealm extends AuthorizingRealm {

    /**
     * @Description 认证方法
     * Realm在接到内部认证组件authenticator组件后很伤心，最后对电脑前的你说：“大兄弟，对不住了，你去实现一下呗”。
     * 从图中的方法体中可以看到，当前对象是Realm类对象，即将调用的方法是doGetAuthenticationInfo(token)。
     * 而这个方法，就是你即将要重写的方法。如果帐号密码通过了，那么返回一个认证成功的info凭证。如果认证失败，抛出一个异常就好了。
     * 你说：“什么?最终还是劳资来认证？”没错，就是苦逼的你去实现了，谁叫你是程序猿呢。
     * 所以，你不得不查询一下数据库，重写doGetAuthenticationInfo方法，查出来正确的帐号密码，返回一个正确的凭证info
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取登录名
        String loginName = (String) authenticationToken.getPrincipal();

        // 查出来正确的帐号密码
        SecurityService securityService = new SecurityServiceImpl();
        String password = securityService.findPasswordByLoginName(loginName);
        if("".equals(password)){
            throw  new UnknownAccountException("账户不存在");
        }
        // 返回一个正确的凭证info
        return new SimpleAuthenticationInfo(loginName,password,getName());
    }

    /**
     * @Description 鉴权方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
