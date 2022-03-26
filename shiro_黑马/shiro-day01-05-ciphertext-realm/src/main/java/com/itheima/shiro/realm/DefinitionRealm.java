package com.itheima.shiro.realm;

import com.itheima.shiro.service.SecurityService;
import com.itheima.shiro.service.impl.SecurityServiceImpl;
import com.itheima.shiro.tools.DigestsUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Map;

/**
 * @Description：
 */
public class DefinitionRealm extends AuthorizingRealm {
    // TODO 阅读源码，看一下比较器是哪一步在使用。
    // 指定密码匹配方式
    // 为DefinitionRealm类添加构造方法如下
    public DefinitionRealm() {
        //指定密码匹配方式sha1
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher(DigestsUtil.SHA1);
        //指定密码迭代次数
        hashedCredentialsMatcher.setHashIterations(DigestsUtil.ITERATIONS);
        //使用父层方法使匹配方式生效
        setCredentialsMatcher(hashedCredentialsMatcher);
    }

    /**
     * @Description 认证方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取登录名
        String loginName = (String) authenticationToken.getPrincipal();
        SecurityService securityService = new SecurityServiceImpl();
        Map<String, String> map = securityService.findPasswordByLoginName(loginName);
        if(map.isEmpty()){
            throw  new UnknownAccountException("账户不存在");
        }
        String salt = map.get("salt");
        String password = map.get("password");
        //传递账号和密码:参数1：缓存对象，参数2：明文密码，参数3：字节salt,参数4：当前DefinitionRealm名称
        return new SimpleAuthenticationInfo(loginName,password, ByteSource.Util.bytes(salt),getName());
    }

    /**
     * @Description 鉴权方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
