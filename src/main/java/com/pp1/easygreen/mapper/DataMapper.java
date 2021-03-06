package com.pp1.easygreen.mapper;

import com.pp1.easygreen.entity.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataMapper {
    Data selectByUserId(Long userId);

    Data selectByPrimaryKey(Long id);

    List<Data> selectDataListByUserId(Long userId);

    int deleteByPrimaryKey(Long id);

    int insert(Data dataRecord);

    List<Data> selectDataList();

    int updateByPrimaryKeySelective(Data dataRecord);
}
