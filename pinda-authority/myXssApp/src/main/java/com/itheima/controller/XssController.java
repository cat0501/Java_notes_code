package com.itheima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cat
 * @description
 * @date 2022/3/7 上午9:15
 */
@RestController
@RequestMapping("/xss")
public class XssController {
    @GetMapping("/get")
    public String get(String text){
        return "处理之后的文本内容为：" + text;
    }
}
