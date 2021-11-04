package com.pp1.easygreen.mapper;
import org.apache.ibatis.annotations.Mapper;

import com.pp1.easygreen.entity.Plant;


import java.util.List;

@Mapper
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
