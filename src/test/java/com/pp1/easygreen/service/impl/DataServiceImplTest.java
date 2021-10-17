package com.pp1.easygreen.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.pp1.easygreen.entity.Data;
import com.pp1.easygreen.mapper.DataMapper;
import com.pp1.easygreen.service.DataService;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

class DataServiceImplTest {
    @Resource
    DataService dataService;

    @Resource
    DataMapper dataMapper;

    Data generateData() {
        Data data = new Data();

        data.setPlantId(RandomUtil.randomLong(10));
        data.setUserId(RandomUtil.randomLong(10));
        data.setTemperature(RandomUtil.randomString(11));
        data.setHumidity(RandomUtil.randomString(11));
        data.setSoilMoisture(RandomUtil.randomString(11));
        data.setLightIntensity(RandomUtil.randomString(11));
        return data;
    }

    @Test
    void getDataByUserId() {
    }

    @Test
    void getDataListByUserId() {
    }
}