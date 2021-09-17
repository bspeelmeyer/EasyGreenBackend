package com.pp1.easygreen.service;

import com.pp1.easygreen.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> getAllAdminInfo();

    Admin createAdmin(Admin admin);
}
