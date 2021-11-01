package com.pp1.easygreen.service;

import com.pp1.easygreen.entity.Data;

import java.util.List;

public interface DataService {
    Data getDataByUserId(Long userId);

    List<Data> getDataListByUserId(Long userId);

    boolean deleteData(Long id);
}
