package com.pp1.easygreen.controller;

import com.pp1.easygreen.entity.BaseUser;
import com.pp1.easygreen.entity.User;
import com.pp1.easygreen.service.UserService;
import com.pp1.easygreen.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

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
    public CommonResult<BaseUser> login(@RequestBody JSONObject param) throws IOException {
        String email = param.getString("email");
        String password = param.getString("password");
        BaseUser user = userService.loginIn(email, password);
        if (user != null) {
            return CommonResult.success(user);
        }
        else {
            return CommonResult.validateFailed("username or password is wrong");
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public CommonResult<User> createUser(@RequestBody JSONObject param) throws IOException {
        User newUser = new User(
                param.getString("firstname"),
                param.getString("lastname"),
                param.getString("username"),
                param.getString("password"),
                param.getString("email"),
                param.getString("phone"),
                param.getString("gender"),
                param.getLong("dateOfBirth"),
                param.getString("address")
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
    public CommonResult<List<User>> getAllUserInfo() throws IOException {
        return CommonResult.success(userService.getAllUserInfo());
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public CommonResult<User> getUserInfo(@PathVariable(name = "id") Long id) throws IOException {
        User user = userService.getUserInfo(id);
        if (user == null) {
            return CommonResult.failed("Get user information failed");
        }
        return CommonResult.success(user);
    }

}
