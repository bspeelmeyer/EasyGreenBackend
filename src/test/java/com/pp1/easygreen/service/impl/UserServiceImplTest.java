package com.pp1.easygreen.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.pp1.easygreen.entity.User;
import com.pp1.easygreen.mapper.UserMapper;
import com.pp1.easygreen.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserServiceImplTest {
    @Resource
    UserService userService;

    @Resource
    UserMapper userMapper;

    User generateRandomUser() {
        User user = new User();
        user.setFirstName(RandomUtil.randomString(11));
        user.setLastName(RandomUtil.randomString(11));
        user.setEmail(RandomUtil.randomString(11));
        user.setPhone(RandomUtil.randomString(11));
        user.setAddress(RandomUtil.randomString(11));
        return user;
    }

    @Test
    void getAllUserInfo() {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        userMapper.insert(user1);
        userMapper.insert(user2);
        userMapper.insert(user3);

        assert userService.getAllUserInfo().size() >= 6;
        assert userMapper.deleteByPrimaryKey(user1.getId()) == 1;
        assert userMapper.deleteByPrimaryKey(user2.getId()) == 1;
        assert userMapper.deleteByPrimaryKey(user3.getId()) == 1;

    }

    @Test
    void createUser() {
        User user = generateRandomUser();
        user = userService.createUser(user);
        assert user.getId() != null;
        assert userMapper.deleteByPrimaryKey(user.getId()) == 1;
    }

    @Test
    void getUserInfo() {
        User user = generateRandomUser();
        user.setFirstName("Miss Viola");
        user = userService.createUser(user);
        assert userService.getUserInfo(user.getId()).getFirstName().equals("Miss Viola");
        assert userMapper.deleteByPrimaryKey(user.getId()) == 1;
    }
}