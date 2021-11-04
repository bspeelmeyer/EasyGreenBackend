package com.pp1.easygreen.controller;

import com.alibaba.fastjson.JSONObject;
import com.pp1.easygreen.entity.Data;
import com.pp1.easygreen.service.DataService;
import com.pp1.easygreen.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/data/onePlant/{Id}", method = RequestMethod.GET)
    public CommonResult<Data> getDataById(@PathVariable(name = "Id") Long id) throws IOException {
        return CommonResult.success(dataService.getDataById(id));
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

    @RequestMapping(value = "/data", method = RequestMethod.PUT)
    public CommonResult<String> updateData(@RequestBody JSONObject param) {
        Data data = new Data(
                param.getLong("id"),
                param.getString("temperature"),
                param.getString("humidity"),
                param.getString("soilMoisture"),
                param.getString("lightIntensity"),
                param.getLong("collectTime")
        );
        dataService.updateData(data);
        return CommonResult.success("Data has been updated");
    }
}
