package com.pp1.easygreen.service.impl;

import com.pp1.easygreen.entity.Data;
import com.pp1.easygreen.entity.Plant;
import com.pp1.easygreen.mapper.DataMapper;
import com.pp1.easygreen.mapper.PlantMapper;
import com.pp1.easygreen.service.DataService;
import com.pp1.easygreen.service.PlantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class PlantServiceImpl implements PlantService {
    @Resource
    private PlantMapper plantMapper;

    @Override
    public Plant getPlantByPlantId(Long plantId) {
        return plantMapper.selectByPlantId(plantId);
    }

    @Override
    public List<Plant> getAllPlant() {
        return plantMapper.selectPlantList();
    }

    @Override
    public boolean deletePlant(Long id) {
        if (plantMapper.deleteByPrimaryKey(id) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Plant createPlant(Plant plant) {
        if (plantMapper.insert(plant) > 0) {
            return plant;
        }
        return null;
    }

    @Override
    public int updatePlant(Plant plant) {
        return plantMapper.updateByPrimaryKeySelective(plant);
    }
}
