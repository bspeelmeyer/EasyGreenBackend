package com.pp1.easygreen.mapper;

import com.pp1.easygreen.entity.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DataMapper {
    Data selectByUserId(Long userId);
}
