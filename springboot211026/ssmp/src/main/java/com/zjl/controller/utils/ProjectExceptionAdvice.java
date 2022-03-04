package com.zjl.controller.utils;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author cat
 * @description
 * @date 2022/3/4 上午10:02
 */
// 作为springmvc的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    // 拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    public R doException(Exception e){
        // 记录日志
        // 通知运维
        // 通知开发
        e.printStackTrace();
        return new R("服务器故障，请稍后重试哈！");
    }
}
