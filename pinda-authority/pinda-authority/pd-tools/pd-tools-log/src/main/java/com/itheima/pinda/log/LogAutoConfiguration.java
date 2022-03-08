package com.itheima.pinda.log;


import com.itheima.pinda.log.aspect.SysLogAspect;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 日志自动配置
 * <p>
 * 启动条件：
 * 1，存在web环境
 * 2，配置文件中pinda.log.enabled=true
 * 3，配置文件中不存在：pinda.log.enabled 值
 *
 */
@EnableAsync
@Configuration
@AllArgsConstructor
@ConditionalOnWebApplication
@ConditionalOnProperty(name = "pinda.log.enabled", havingValue = "true", matchIfMissing = true)
public class LogAutoConfiguration {

    @Bean
    // 解释1：仅在该注解规定的类不存在于 spring容器中时,使用该注解的config或者bean声明才会被实例化到容器中

    // 解释2：它是修饰bean的一个注解，主要实现的是，当你的bean被注册之后，如果注册相同类型的bean，就不会成功，
    // 它会保证你的bean只有一个，即你的实例只有一个，当你注册多个相同的bean时，会出现异常，以此来告诉开发人员。
    @ConditionalOnMissingBean
    public SysLogAspect sysLogAspect() {
        return new SysLogAspect();
    }
}
