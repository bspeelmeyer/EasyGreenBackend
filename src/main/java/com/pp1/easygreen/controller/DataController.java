package com.pp1.easygreen.controller;

import com.pp1.easygreen.entity.Data;
import com.pp1.easygreen.entity.Plant;
import com.pp1.easygreen.service.DataService;
import com.pp1.easygreen.service.PlantService;
import com.pp1.easygreen.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/data/{userId}", method = RequestMethod.GET)
    public CommonResult<Data> getDataByUserId(@PathVariable(name = "userId") Long userId) throws IOException {
        Data data = dataService.getDataByUserId(userId);
        if (data == null) {
            return CommonResult.failed("Get data failed");
        }
        return CommonResult.success(data);
    }

    @RequestMapping(value = "/data/plant/{userId}", method = RequestMethod.GET)
    public CommonResult<List<Data>> getDataListByUserId(@PathVariable(name = "userId") Long userId) throws IOException {
        return CommonResult.success(dataService.getDataListByUserId(userId));
    }

    @RequestMapping(value = "/data/delete-plant/{id}", method = RequestMethod.POST)
    public CommonResult<Long> deleteDataBySelected(@PathVariable(name = "id") Long id) throws IOException {
        boolean data = dataService.deleteData(id);
        if (data == true) {
            return CommonResult.success(id);
        }
        else {
            return CommonResult.validateFailed("Delete unsuccessful");
        }
    }
}
