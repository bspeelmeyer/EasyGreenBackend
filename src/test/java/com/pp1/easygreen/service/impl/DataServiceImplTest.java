package com.pp1.easygreen.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.pp1.easygreen.entity.Data;
import com.pp1.easygreen.mapper.DataMapper;
import com.pp1.easygreen.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
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
        Date collectTime = new Date((long) 1619065800 * 1000);
        data.setCollectTime(collectTime);
        return data;
    }

    @Test
    void getDataByUserId() {
        Data d1 = generateData();
        assert dataMapper.insert(d1) == 1;
        assert d1.getUserId() != null;
        Data tmpD1 = dataService.getDataByUserId(d1.getUserId());
        assert tmpD1.getUserId().equals(d1.getUserId());
        assert tmpD1.getLightIntensity().equals(d1.getLightIntensity());
        assert dataMapper.deleteByPrimaryKey(d1.getId()) == 1;
    }

    @Test
    void getDataListByUserId() {
        Data d1 = generateData();
        Data d2 = generateData();
        Data data = new Data();
        assert dataMapper.insert(data) == 1;
        d1.setUserId(data.getUserId());
        d2.setUserId(data.getUserId());

        d1 = dataService.createData(d1);
        d2 = dataService.createData(d2);

        List<Data> dataList = dataService.getDataListByUserId(data.getUserId());
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

    @Test
    void updateData() {
        Data data = new Data();
        data.setId(RandomUtil.randomLong(10));
        data.setPlantId(RandomUtil.randomLong(10));
        data.setUserId(RandomUtil.randomLong(10));
        data.setLightIntensity("100");
        data.setHumidity("100");
        data.setSoilMoisture("100");
        data.setTemperature("50");
        Date collectTime = new Date((long) 1619065800 * 1000);
        data.setCollectTime(collectTime);
        data = dataService.createData(data);
        data.setTemperature("20");
        assert dataService.updateData(data) == 1;
        assert "20".equals(dataMapper.selectByPrimaryKey(data.getId()).getTemperature());
        assert dataMapper.deleteByPrimaryKey(data.getId()) == 1;
    }
}