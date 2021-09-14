package com.pp1.easygreen.service;

import com.pp1.easygreen.entity.User;

import java.util.List;

public interface UserService {

    User loginIn(String username, String password);

    public List<User> getAllUserInfo();

    User createUser(User user);

    User getByUsername(String username);

}
