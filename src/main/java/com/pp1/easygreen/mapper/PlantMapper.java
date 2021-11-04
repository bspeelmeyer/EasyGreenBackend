package com.pp1.easygreen.mapper;

import com.pp1.easygreen.entity.Plant;

import java.util.List;

public interface PlantMapper {
    Plant selectByPlantId(Long plantId);

    List<Plant> selectPlantList();

    /**
     * This method corresponds to the database table location
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method corresponds to the database table location
     */
    int insert(Plant plantRecord);

    /**
     * This method corresponds to the database table location
     */
    int updateByPrimaryKeySelective(Plant plantRecord);
}
