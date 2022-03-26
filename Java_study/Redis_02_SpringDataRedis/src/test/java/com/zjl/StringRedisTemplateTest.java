package com.zjl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zjl.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author cat
 * @description
 * @date 2022/3/12 下午6:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StringRedisTemplateTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    // Json工具
    private static final ObjectMapper mapper = new ObjectMapper();


    @Test
    public void testStringRedisTemplate() throws JsonProcessingException {
        // 准备对象
        User user = new User("admin","123456");
        // 手动序列化
        String valueAsString = mapper.writeValueAsString(user);
        // 写入一条数据到Redis
        stringRedisTemplate.opsForValue().set("user",valueAsString);

        // 读取数据
        String userString = stringRedisTemplate.opsForValue().get("user");
        // 反序列化
        User userValue = mapper.readValue(userString, User.class);
        System.out.println(userValue);
    }

}
