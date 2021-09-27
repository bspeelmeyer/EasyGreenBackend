package com.pp1.easygreen.service.impl;

import com.pp1.easygreen.entity.Data;
import com.pp1.easygreen.mapper.DataMapper;
import com.pp1.easygreen.service.DataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class DataServiceImpl implements DataService {
    @Resource
    private DataMapper dataMapper;

    @Override
    public Data getDataByUserId(Long userId) {
        return dataMapper.selectByUserId(userId);
    }
}
