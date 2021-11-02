package com.pp1.easygreen.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.pp1.easygreen.entity.Data;
import com.pp1.easygreen.mapper.DataMapper;
import com.pp1.easygreen.service.DataService;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataServiceImplTest {
    @Resource
    DataService dataService;

    @Resource
    DataMapper dataMapper;

    Data generateData() {
        Data data = new Data();

        data.setId(RandomUtil.randomLong(10));
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
        Data d1 = generateData();
        assert dataMapper.insert(d1) == 1;
        assert d1.getId() != null;
        Data tmpD1 = dataService.getDataByUserId(d1.getId());
        assert tmpD1.getId().equals(d1.getId());
        assert tmpD1.getLightIntensity().equals(d1.getLightIntensity());
        assert dataMapper.deleteByPrimaryKey(d1.getId()) == 1;
    }

    @Test
    void getDataListByUserId() {
        Data d1 = generateData();
        Data d2 = generateData();
        Data data = new Data();
        assert dataMapper.insert(data) == 1;
        d1.setUserId(data.getId());
        d2.setUserId(data.getId());

        d1 = dataService.createData(d1);
        d2 = dataService.createData(d2);

        List<Data> dataList = dataService.getDataListByUserId(data.getId());
        assert dataList.size() == 2;
        assert dataMapper.deleteByPrimaryKey(d1.getId()) == 1;
        assert dataMapper.deleteByPrimaryKey(d2.getId()) == 1;
        assert dataMapper.deleteByPrimaryKey(data.getId()) == 1;
    }

    @Test
    void deleteData() {
        Data d1 = generateData();
        d1 = dataService.createData(d1);
        assert dataService.deleteData(d1.getId());
    }

    @Test
    void getAllData() {
        Data d1 = generateData();
        Data d2 = generateData();
        d1 = dataService.createData(d1);
        d2 = dataService.createData(d2);

        List<Data> dataList = dataService.getAllData();
        assert dataList.size() >= 2;
        assert dataMapper.deleteByPrimaryKey(d1.getId()) == 1;
        assert dataMapper.deleteByPrimaryKey(d2.getId()) == 1;
    }
}