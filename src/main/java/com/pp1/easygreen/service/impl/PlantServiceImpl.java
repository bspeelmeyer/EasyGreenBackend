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

@Slf4j
@Service
public class PlantServiceImpl implements PlantService {
    @Resource
    private PlantMapper plantMapper;

    @Override
    public Plant getPlantByPlantId(Long plantId) {
        return plantMapper.selectByPlantId(plantId);
    }
}
