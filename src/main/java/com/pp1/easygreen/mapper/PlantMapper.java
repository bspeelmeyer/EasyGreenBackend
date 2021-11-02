package com.pp1.easygreen.mapper;

import com.pp1.easygreen.entity.Plant;

import java.util.List;

public interface PlantMapper {
    Plant selectByPlantId(Long plantId);

    List<Plant> selectPlantList();

    int deleteByPrimaryKey(Long id);

    int insert(Plant plantRecord);

    int updateByPrimaryKeySelective(Plant plantRecord);
}
