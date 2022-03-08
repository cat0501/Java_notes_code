package cn.itcast.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cat
 * @description 全局异常处理
 * @date 2022/3/7 下午6:10
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    //异常处理方法，Controller发生异常后会执行此方法，在此进行统一处理
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        System.out.println("统一处理异常信息:" + e.getMessage());
        return "系统错误";
    }
}
