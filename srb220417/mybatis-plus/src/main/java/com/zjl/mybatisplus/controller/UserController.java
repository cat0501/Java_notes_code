package com.zjl.mybatisplus.controller;

import com.zjl.mybatisplus.entity.User;
import com.zjl.mybatisplus.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cat
 * @description
 * @date 2022/4/17 下午7:56
 */
@RestController
@RequestMapping("/user")
@CrossOrigin //解决跨域问题
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping("/list")
    public List<User> list(){
        return userService.list();
    }
}
