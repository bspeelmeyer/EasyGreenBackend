package com.pp1.easygreen.service.impl;

import com.pp1.easygreen.entity.Data;
import com.pp1.easygreen.mapper.DataMapper;
import com.pp1.easygreen.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class DataServiceImpl implements DataService {
    @Resource
    private DataMapper dataMapper;

    @Override
    public Data getDataByUserId(Long userId) {
        return dataMapper.selectByUserId(userId);
    }

    @Override
    public List<Data> getDataListByUserId(Long userId) {
        return dataMapper.selectDataListByUserId(userId);
    }

    @Override
    public boolean deleteData(Long id) {
        if (dataMapper.deleteByPrimaryKey(id) > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Data createData(Data data) {
        if (dataMapper.insert(data) > 0) {
            return data;
        }
        return null;
    }

    @Override
    public List<Data> getAllData() {
        return dataMapper.selectDataList();
    }

    @Override
    public int updateData(Data data) {
        return dataMapper.updateByPrimaryKeySelective(data);
    }

    @Override
    public Data getDataById(Long id) {
        return dataMapper.selectByPrimaryKey(id);
    }
}
