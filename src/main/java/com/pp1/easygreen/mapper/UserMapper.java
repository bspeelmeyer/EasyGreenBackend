package com.pp1.easygreen.mapper;

import com.pp1.easygreen.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    User getInfo(String username, String password);

    List<User> selectAll();

    User selectByEmail(String email);

    int insert(User userRecord);

    User selectByPrimaryKey(Long id);
}
