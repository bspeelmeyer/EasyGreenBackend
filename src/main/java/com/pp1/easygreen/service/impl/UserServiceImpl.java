package com.pp1.easygreen.service.impl;

import com.pp1.easygreen.entity.Admin;
import com.pp1.easygreen.entity.BaseUser;
import com.pp1.easygreen.entity.User;
import com.pp1.easygreen.mapper.AdminMapper;
import com.pp1.easygreen.mapper.UserMapper;
import com.pp1.easygreen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.parameters.P;
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
    @Resource
    private AdminMapper adminMapper;
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
    public BaseUser getByEmail(String email) {
        User user = userMapper.selectByEmail(email);
        BaseUser baseUser = new BaseUser(email);
        if (user != null) {
            baseUser.setId(user.getId());
            baseUser.setPassword(user.getPassword());
            baseUser.setEmail(user.getEmail());
            baseUser.setName(user.getUserName());
            baseUser.setRole("USER");
            return baseUser;
        }
        Admin admin = adminMapper.selectByEmail(email);
        if (admin != null) {
            baseUser.setId(admin.getId());
            baseUser.setPassword(admin.getPassword());
            baseUser.setEmail(admin.getEmail());
            baseUser.setName(admin.getName());
            baseUser.setRole("ADMIN");
            return baseUser;
        }
        return null;
    }

    @Override
    public BaseUser loginIn(String email, String password) {
        BaseUser user = getByEmail(email);
        if (user.getPassword().equals(password)) {
            final String token = jwtTokenUtil.generateToken(userDetailsService.loadUserByUsername(email));
            user.setToken(token);
            // log.info(user.toString());
            return user;
        }
        return null;
    }

    @Override
    public User createUser(User user) {
        if (userMapper.selectByEmail(user.getEmail()) != null) {
            user.setId(-1L);
            return user;
        }
        int result = userMapper.insert(user);
        if (result > 0) {
            return userMapper.selectByEmail(user.getEmail());
        }
        return null;
    }

    @Override
    public User getUserInfo(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateUserProfile(User user) {
        int result = userMapper.updateByPrimaryKeySelective(user);
        return result > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userMapper.deleteByPrimaryKey(id) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
