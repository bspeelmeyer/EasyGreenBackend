package com.pp1.easygreen.mapper;
import org.apache.ibatis.annotations.Mapper;

import com.pp1.easygreen.entity.Plant;

@Mapper
public interface PlantMapper {
    Plant selectByPlantId(Long plantId);
}
