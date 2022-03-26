package com.zjl;

import com.zjl.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testString() {
        // 插入一条string类型数据
        redisTemplate.opsForValue().set("name", "李四");
        // 读取一条string类型数据
        Object name = redisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    @Test
    public void testUser() {
        // 插入一条User类型数据
        User user = new User();
        user.setUsername("root");
        user.setPassword("123456");

        redisTemplate.opsForValue().set("user", user);
        // 读取一条string类型数据
        Object name = redisTemplate.opsForValue().get("user");
        System.out.println("user = " + user);
    }
}

