package com.pp1.easygreen.service;

import com.pp1.easygreen.entity.Plant;

import java.util.List;

public interface PlantService {
    Plant getPlantByPlantId(Long plantId);

    List<Plant> getAllPlant();

    boolean deletePlant(Long id);

    Plant createPlant(Plant plant);

    int updatePlant(Plant plant);
}
