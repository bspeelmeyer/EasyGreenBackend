package com.pp1.easygreen.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.pp1.easygreen.entity.Admin;
import com.pp1.easygreen.mapper.AdminMapper;
import com.pp1.easygreen.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
class AdminServiceImplTest {
    @Resource
    AdminMapper adminMapper;

    @Resource
    AdminService adminService;

    Admin generateRandomStaff() {
        Admin admin = new Admin();
        admin.setName(RandomUtil.randomString(11));
        admin.setEmail(RandomUtil.randomString(11));
        admin.setPhone(RandomUtil.randomString(11));
        return admin;
    }

    @Test
    void getAdminInfo() {
        Admin admin = generateRandomStaff();
        admin.setName("Mr Bean");
        admin = adminService.createAdmin(admin);
        assert adminService.getAdminInfo(admin.getId()).getName().equals("Mr Bean");
        assert adminMapper.deleteByPrimaryKey(admin.getId()) == 1;
    }

    @Test
    void createAdmin() {
        Admin admin = generateRandomStaff();
        admin = adminService.createAdmin(admin);
        assert admin.getId() != null;
        assert adminMapper.deleteByPrimaryKey(admin.getId()) == 1;
    }

    @Test
    void getAllAdminInfo() {
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();
        Admin admin3 = new Admin();
        adminMapper.insert(admin1);
        adminMapper.insert(admin2);
        adminMapper.insert(admin3);

        assert adminService.getAllAdminInfo().size() >= 6;
        assert adminMapper.deleteByPrimaryKey(admin1.getId()) == 1;
        assert adminMapper.deleteByPrimaryKey(admin2.getId()) == 1;
        assert adminMapper.deleteByPrimaryKey(admin3.getId()) == 1;
    }
}
