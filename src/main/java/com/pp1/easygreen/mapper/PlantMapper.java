package com.pp1.easygreen.mapper;

import com.pp1.easygreen.entity.Plant;

public interface PlantMapper {
    Plant selectByPlantId(Long plantId);
}
