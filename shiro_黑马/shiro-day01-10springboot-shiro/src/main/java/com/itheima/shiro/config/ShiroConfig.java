package com.itheima.shiro.config;

import com.itheima.shiro.core.ShiroDbRealm;
import com.itheima.shiro.core.filter.RolesOrAuthorizationFilter;
import com.itheima.shiro.core.impl.ShiroDbRealmImpl;
import com.itheima.shiro.properties.PropertiesUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description：权限管理配置类
 */
@Configuration
@ComponentScan(basePackages = "com.itheima.shiro.core")
@Log4j2
//p37讲解
public class ShiroConfig {

    // 1,创建cookie对象
    // 创建SimpleCookie，访问项目时，会在客户端中cookie中存放ShiroSession的对
    @Bean(name = "simpleCookie")
    public SimpleCookie simpleCookie(){
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName("ShiroSession");
        return simpleCookie;
    }

    // 2,创建权限管理器
    @Bean("securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //管理realm
        securityManager.setRealm(shiroDbRealm());
        //管理会话
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }


    // --------------------------------------------------------------------------------
    // 自定义realm
    @Bean("shiroDbRealm")
    public ShiroDbRealm shiroDbRealm(){
        return new ShiroDbRealmImpl();
    }

    // 会话管理器
    @Bean("sessionManager")
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //关闭会话更新
        sessionManager.setSessionValidationSchedulerEnabled(false);
        //生效cookie
        sessionManager.setSessionIdCookieEnabled(true);
        //指定cookie的生成策略
        sessionManager.setSessionIdCookie(simpleCookie());
        //指定全局会话超时时间1小时
        sessionManager.setGlobalSessionTimeout(3600000);
        return sessionManager;
    }
    // --------------------------------------------------------------------------------


    // 3,创建生命周期的管理
    // static的原因：优先加载？
    @Bean("lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }



    // 4,aop增强（使用注解鉴权方式）
    /**
     * @Description AOP式方法级权限检查
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * @Description 配合DefaultAdvisorAutoProxyCreator事项注解权限校验
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();

        aasa.setSecurityManager(defaultWebSecurityManager());
        return new AuthorizationAttributeSourceAdvisor();
    }



    // 5,shiro过滤器管理
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());
        //设置自定义过滤器 RolesOrAuthorizationFilter
        shiroFilterFactoryBean.setFilters(filters());
        //过滤器链
        // authentication.properties读取，内容加载
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap());
        shiroFilterFactoryBean.setLoginUrl("/login");
        //未授权跳转路径
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");
        // 过滤器返回spring
        return shiroFilterFactoryBean;
    }

    // --------------------------------------------------------------------------------
    /**
     * @Description 过滤器链定义
     */
    private Map<String,String> filterChainDefinitionMap(){
        // authentication.properties读取
        List<Object> list =  PropertiesUtil.propertiesShiro.getKeyList();
        // 有序map
        Map<String,String> map = new LinkedHashMap<>();
        for (Object o : list) {
            String key = o.toString();
            String val = PropertiesUtil.getShiroValue(key);
            map.put(key, val);
        }
        return map;
    }

    /**
     * @Description 自定义过滤器定义
     */
    private Map<String, Filter> filters(){
        Map<String,Filter> map = new HashMap<>();
        map.put("roles-or", new RolesOrAuthorizationFilter());
        return map;
    }
}
