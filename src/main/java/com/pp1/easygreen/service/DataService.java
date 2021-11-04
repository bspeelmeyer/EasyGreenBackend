package com.pp1.easygreen.service;

import com.pp1.easygreen.entity.Data;

import java.util.List;

public interface DataService {
    Data getDataByUserId(Long userId);

    List<Data> getDataListByUserId(Long userId);

    boolean deleteData(Long id);

    Data createData(Data data);

    List<Data> getAllData();

    int updateData(Data data);

    Data getDataById(Long id);
}
