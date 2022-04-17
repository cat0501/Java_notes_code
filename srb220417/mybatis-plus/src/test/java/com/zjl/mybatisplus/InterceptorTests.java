package com.zjl.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjl.mybatisplus.entity.User;
import com.zjl.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cat
 * @description
 * @date 2022/4/17 下午1:57
 */
@SpringBootTest
public class InterceptorTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectPage(){

        //创建分页参数
        Page<User> pageParam = new Page<>(1,5);
        //执行分页查询
        userMapper.selectPage(pageParam, null);
        //查看分页参数的成员
        System.out.println(pageParam);
    }


    @Test
    public void testSelectPageVo(){
        // ==>  Preparing: SELECT COUNT(*) FROM t_user WHERE age > ?
        // ==> Parameters: 18(Integer)
        // <==    Columns: COUNT(*)
        // <==        Row: 4
        // <==      Total: 1

        // ==>  Preparing: SELECT uid, name, age, email FROM t_user WHERE age > ? LIMIT ?
        // ==> Parameters: 18(Integer), 5(Long)

        Page<User> pageParam = new Page<>(1,5);
        userMapper.selectPageByPage(pageParam, 18);

        List<User> users = pageParam.getRecords();
        users.forEach(System.out::println);
    }
}
