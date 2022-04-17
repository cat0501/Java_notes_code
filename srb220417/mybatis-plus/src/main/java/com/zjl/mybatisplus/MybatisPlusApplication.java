package com.zjl.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author cat
 * @description
 * @date 2022/4/17 上午11:00
 */

@SpringBootApplication
@MapperScan("com.zjl.mybatisplus.mapper")
public class MybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }
}
