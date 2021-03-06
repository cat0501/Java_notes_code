package com.zjl.mybatisplus;

import com.zjl.mybatisplus.entity.User;
import com.zjl.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cat
 * @description
 * @date 2022/4/17 上午11:07
 */
@SpringBootTest
public class MybatisPlusApplicationTests {
    //@Autowired //默认按类型装配。是spring的注解
    @Resource //默认按名称装配，找不到与名称匹配的bean，则按照类型装配。是J2EE的注解
    private UserMapper userMapper;

    @Test
    void testSelectList() {
        //selectList()方法的参数：封装了查询条件
        //null：无任何查询条件
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
