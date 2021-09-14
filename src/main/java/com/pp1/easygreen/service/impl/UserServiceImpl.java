package com.pp1.easygreen.service.impl;

import com.pp1.easygreen.entity.User;
import com.pp1.easygreen.mapper.UserMapper;
import com.pp1.easygreen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.pp1.easygreen.security.jwt.JwtTokenUtil;
import org.springframework.security.core.userdetails.UserDetailsService;


import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public List<User> getAllUserInfo() {
        return userMapper.selectAll();
    }

    @Override
    public User getByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        if (user != null) {
            user.setId(user.getId());
            user.setFirstName(user.getFirstName());
            user.setLastName(user.getLastName());
            user.setUserName(user.getUserName());
            user.setPassword(user.getPassword());
            user.setEmail(user.getEmail());
            user.setPhone(user.getPhone());
            user.setGender(user.getGender());
            user.setDateOfBirth(user.getDateOfBirth());
            user.setAddress(user.getAddress());
            return user;
        }
        return null;
    }

    @Override
    public User loginIn(String username, String password) {
        User user = getByUsername(username);
        if (user.getPassword().equals(password)) {
            final String token = jwtTokenUtil.generateToken(userDetailsService.loadUserByUsername(username));
            user.setToken(token);
            log.info(user.toString());
            return user;
        }
        return null;
    }

    @Override
    public User createUser(User user) {
        if (userMapper.selectByUsername(user.getUserName()) != null) {
            user.setId(-1L);
            return user;
        }
        int result = userMapper.insert(user);
        if (result > 0) {
            return userMapper.selectByUsername(user.getUserName());
        }
        return null;
    }

}
