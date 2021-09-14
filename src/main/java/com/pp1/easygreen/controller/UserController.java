package com.pp1.easygreen.controller;

import com.pp1.easygreen.entity.User;
import com.pp1.easygreen.service.UserService;
import com.pp1.easygreen.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public CommonResult<User> login(@RequestBody JSONObject param) throws IOException {
        String username = param.getString("username");
        String password = param.getString("password");
        User user = userService.loginIn(username, password);
        if (user != null) {
            return CommonResult.success(user);
        }
        else {
            return CommonResult.validateFailed("username or password is wrong");
        }
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public CommonResult<User> createUser(@RequestBody User user) throws IOException {
        User newUser = new User(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(),
                user.getGender(),
                user.getDateOfBirth(),
                user.getAddress()
        );
        newUser = userService.createUser(newUser);
        int userDuplicateFlag = -1;
        if (newUser == null) {
            return CommonResult.failed("Cannot create a user");
        }
        if (newUser.getId() == userDuplicateFlag) {
            return CommonResult.failed("Cannot create: user has already existed");
        }
        return CommonResult.success(newUser);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public CommonResult<List<User>> getAllStaffInfo() throws IOException {
        return CommonResult.success(userService.getAllUserInfo());
    }

}
