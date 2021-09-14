package com.pp1.easygreen;

import com.pp1.easygreen.entity.User;
import com.pp1.easygreen.mapper.UserMapper;
import com.pp1.easygreen.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EasygreenApplication.class)
public class EasygreenApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        User user = userService.loginIn("user", "user");
        System.out.print("UserId: ");
        System.out.println(user.getId());
    }

    @Test
    public void testMapper() {
        System.out.println(userMapper.selectByUsername("user"));
    }
}
