package com.pp1.easygreen.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.pp1.easygreen.entity.Plant;
import com.pp1.easygreen.mapper.PlantMapper;
import com.pp1.easygreen.service.PlantService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

/**
 * @author Hang Yang
 * @date 02/11/2021 : 1:45 PM
 * @email s3799719@student.rmit.edu.au
 */

@Slf4j
@SpringBootTest
class PlantServiceImplTest {
    @Resource
    PlantService plantService;

    @Resource
    PlantMapper plantMapper;

    Plant generateRandomPlant() {
        Plant plant = new Plant();
        plant.setId(RandomUtil.randomLong(10));
        plant.setPlantName(RandomUtil.randomString(11));
        plant.setDescription(RandomUtil.randomString(11));
        return plant;
    }

    @Test
    void getPlantByPlantId() {
        Plant p1 = generateRandomPlant();
        assert plantMapper.insert(p1) == 1;
        assert p1.getId() != null;

        Plant tmpP1 = plantService.getPlantByPlantId(p1.getId());
        assert tmpP1.getId().equals(p1.getId());
        assert plantMapper.deleteByPrimaryKey(p1.getId()) == 1;
    }

    @Test
    void getAllPlant() {
        Plant p1 = generateRandomPlant();
        Plant p2 = generateRandomPlant();

        p1 = plantService.createPlant(p1);
        p2 = plantService.createPlant(p2);

        List<Plant> plantList = plantService.getAllPlant();
        assert plantList.size() >= 2;
        assert plantMapper.deleteByPrimaryKey(p1.getId()) == 1;
        assert plantMapper.deleteByPrimaryKey(p2.getId()) == 1;
    }

    @Test
    void deletePlant() {
        Plant p1 = generateRandomPlant();
        p1 = plantService.createPlant(p1);
        assert plantService.deletePlant(p1.getId());
    }

    @Test
    void createPlant() {
        Plant plant = generateRandomPlant();
        assert plantService.createPlant(plant).getId() != null;
        assert plantMapper.deleteByPrimaryKey(plant.getId()) == 1;
    }

    @Test
    void updatePlant() {
        Plant plant = new Plant();
        plant.setPlantName("Rose");
        plant.setDescription("Rose Flower");
        plant = plantService.createPlant(plant);
        plant.setPlantName("Tulip");
        assert plantService.updatePlant(plant) == 1;
        assert "Tulip".equals(plantMapper.selectByPlantId(plant.getId()).getPlantName());
        assert plantMapper.deleteByPrimaryKey(plant.getId()) == 1;
    }
}