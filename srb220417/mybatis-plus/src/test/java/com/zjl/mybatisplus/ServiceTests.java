package com.zjl.mybatisplus;

import com.zjl.mybatisplus.entity.User;
import com.zjl.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cat
 * @description
 * @date 2022/4/17 下午12:26
 */
@SpringBootTest
public class ServiceTests {

    @Resource
    private UserService userService;

    /**
     * @description 测试记录数
     * @author Lemonade
     * @param:
     * @updateTime 2022/4/17 下午12:27
     */
    @Test
    public void testCount(){

        int count = userService.count();
        System.out.println("总记录数：" + count);
    }


    /**
     * @description 测试批量插入
     * @author Lemonade
     * @param:
     * @updateTime 2022/4/17 下午12:27
     */
    @Test
    public void testSaveBatch(){

        // SQL长度有限制，海量数据插入单条SQL无法实行，
        // 因此MP将批量插入放在了通用Service中实现，而不是通用Mapper
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("Helen" + i);
            // 用户明确定义了属性值，则无需自动填充，否则使用自动填充
            //user.setAge(10 + i);
            users.add(user);
        }
        userService.saveBatch(users);
    }


    /**
     * @description 根据姓名查找
     * @author Lemonade
     * @param:
     * @updateTime 2022/4/17 下午1:49
     */
    @Test
    public void testListAllByName(){
        List<User> users = userService.listAllByName("Helen");
        users.forEach(System.out::println);
    }

}
