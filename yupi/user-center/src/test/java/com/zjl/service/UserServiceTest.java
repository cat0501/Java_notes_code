package com.zjl.service;
import java.util.Date;

import com.zjl.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;


/**
 * @author cat
 * @description 用户服务测试
 * @date 2022/3/26 下午9:20
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("dog");
        user.setUserAccount("123");
        user.setAvatarUrl("https://static.oschina.net/new-osc/img/logo_new.svg");
        user.setGender((byte)0);
        user.setUserPassword("xxx");
        user.setPhone("123");
        user.setEmail("456");
        user.setUserStatus(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setIsDeleted((byte)0);

        boolean result = userService.save(user);
        // 断言 测试用  可读性更好
        Assertions.assertTrue(result);
        System.out.println(user.getId());
    }

    @Test
    public void testDigest(){
        String newPassword = DigestUtils.md5DigestAsHex(("123456" + "mypassword").getBytes());
        // 1c37  ed13  1ff6  37c9  d0dd  24d8  7b0e  034e
        System.out.println(newPassword);

        final String salt = "2022";
        String newPassword2 = DigestUtils.md5DigestAsHex((salt + "123456").getBytes());
        System.out.println(newPassword2);

    }

    // 还是要多写测试类啊！
    @Test
    void userRegister() {
        String userAccount = "admin123";
        String userPassword = "123456789";
        String checkPassword = "123456789";
        long userId = userService.userRegister(userAccount, userPassword, checkPassword);
        // 断言只推荐在测试类中使用，实际业务中只推荐抛出异常。
        Assertions.assertEquals(-1,userId);
        // 同上，下面可以多写几个断言，进行测试。
        System.out.println(userId);
    }
}