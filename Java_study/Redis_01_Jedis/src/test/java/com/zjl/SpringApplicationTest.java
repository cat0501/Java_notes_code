package com.zjl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

/**
 * @author cat
 * @description
 * @date 2022/3/11 下午3:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=SpringApplicationTest.class)
@ComponentScan
public class SpringApplicationTest {
    private Jedis jedis;

    @Test
    @Before  // Junit4,在每个测试方法之前执行。注解在非静态方法上。
    // @BeforeEach  Junit5
    public void testSetUp() {
        jedis = new Jedis("39.101.189.62", 6379);
        jedis.auth("123456");
        jedis.select(2);
    }

    @Test
    public void testString() {
        System.out.println("-------------插入数据---------------");
        String result = jedis.set("name", "李四");
        System.out.println("result: " + result);

        System.out.println("-------------根据key获取数据---------------");
        String name = jedis.get("name");
        System.out.println("name: " + name);
    }

    @Test
    @After  // Junit4,在每个测试方法之后执行。注解在非静态方法上。
    // @AfterEach  Junit5
    public void testDown() {
        // 释放资源
        if (jedis != null){
            jedis.close();
        }
    }

    @Autowired
    public JedisConnectionFactory jedisByFactory;

    @Test
    public void testFactory() {
        Jedis jedis = JedisConnectionFactory.getJedis();
        jedis.select(2);
        jedis.set("age","18");
        System.out.println(jedis.get("name"));
    }

}
