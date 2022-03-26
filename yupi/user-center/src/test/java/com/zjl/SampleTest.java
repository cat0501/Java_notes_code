package com.zjl;

//import com.zjl.mapper.UserMapper;
import org.junit.Assert;
//使用这个Test，需要添加@RunWith(SpringRunner.class)
import org.junit.Test;

//使用这个Test，不需要添加@RunWith(SpringRunner.class)
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SampleTest {

    //@Resource
    //private UserMapper userMapper;
    //
    //@Test
    //public void testSelect() {
    //    System.out.println(("----- selectAll method test ------"));
    //    //UserMapper 中的 selectList() 方法的参数为 MP 内置的条件封装器 Wrapper，所以不填写就是无任何条件
    //    List<User> userList = userMapper.selectList(null);
    //    Assert.assertEquals(5, userList.size());
    //    userList.forEach(System.out::println);
    //}


    // 小结  https://baomidou.com/pages/226c21/#%E5%88%9D%E5%A7%8B%E5%8C%96%E5%B7%A5%E7%A8%8B
    // 通过以上几个简单的步骤，我们就实现了 User 表的 CRUD 功能，甚至连 XML 文件都不用编写！
    // 从以上步骤中，我们可以看到集成MyBatis-Plus非常的简单，只需要引入 starter 工程，并配置 mapper 扫描路径即可。
    // 但 MyBatis-Plus 的强大远不止这些功能，想要详细了解 MyBatis-Plus 的强大功能？那就继续往下看吧！

}
