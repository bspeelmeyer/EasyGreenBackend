package com.pp1.easygreen.controller;

import com.pp1.easygreen.entity.Admin;
import com.pp1.easygreen.entity.User;
import com.pp1.easygreen.service.AdminService;
import com.pp1.easygreen.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public CommonResult<Admin> createAdmin(@RequestBody JSONObject param) throws IOException {
        Admin admin = param.toJavaObject(Admin.class);
        admin = new Admin(
                param.getString("username"),
                param.getString("password"),
                param.getString("email"),
                param.getString("phone")
        );
        admin = adminService.createAdmin(admin);
        if (admin == null) {
            return CommonResult.failed("Cannot create an admin");
        }
        if (admin.getId() == -1) {
            return CommonResult.failed("This admin account is already existed");
        }
        return CommonResult.success(admin);
    }

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
    public CommonResult<Admin> getAdminInfo(@PathVariable(name = "id") Long id) throws IOException {
        Admin admin = adminService.getAdminInfo(id);
        if (admin == null) {
            return CommonResult.failed("Get admin information failed");
        }
        return CommonResult.success(admin);
    }

}
