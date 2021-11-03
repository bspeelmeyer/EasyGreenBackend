package com.pp1.easygreen.service;

import com.pp1.easygreen.entity.Plant;

import java.util.List;

/**
 * @author Hang Yang
 * @date 02/11/2021 : 1:30 PM
 * @email s3799719@student.rmit.edu.au
 */
public interface PlantService {
    Plant getPlantByPlantId(Long plantId);

    List<Plant> getAllPlant();

    boolean deletePlant(Long id);

    Plant createPlant(Plant plant);

    int updatePlant(Plant plant);
}
