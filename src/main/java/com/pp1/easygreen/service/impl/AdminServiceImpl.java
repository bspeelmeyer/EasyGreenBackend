package com.pp1.easygreen.service.impl;

import com.pp1.easygreen.entity.Admin;
import com.pp1.easygreen.mapper.AdminMapper;
import com.pp1.easygreen.security.jwt.JwtTokenUtil;
import com.pp1.easygreen.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public List<Admin> getAllAdminInfo() {
        return adminMapper.selectAll();
    }

}
