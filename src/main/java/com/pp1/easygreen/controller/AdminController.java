package com.pp1.easygreen.controller;

import com.pp1.easygreen.entity.Admin;
import com.pp1.easygreen.service.AdminService;
import com.pp1.easygreen.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public CommonResult<List<Admin>> getAllStaffInfo() throws IOException {
        return CommonResult.success(adminService.getAllAdminInfo());
    }

}
