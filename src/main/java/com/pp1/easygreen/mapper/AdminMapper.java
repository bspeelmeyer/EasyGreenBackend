package com.pp1.easygreen.mapper;

import com.pp1.easygreen.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<Admin> selectAll();

    Admin selectByEmail(String email);

    int insert(Admin adminRecord);

    Admin selectByPrimaryKey(Long id);
}
