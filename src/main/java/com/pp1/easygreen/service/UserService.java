package com.pp1.easygreen.service;

import com.pp1.easygreen.entity.BaseUser;
import com.pp1.easygreen.entity.User;

import java.util.List;

public interface UserService {

    BaseUser loginIn(String username, String password);

    List<User> getAllUserInfo();

    User createUser(User user);

    BaseUser getByEmail(String email);

    User getUserInfo(Long id);

    boolean updateUserProfile(User user);

}
