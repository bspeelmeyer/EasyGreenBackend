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
    @Autowired
    private PlantService plantService;

    @RequestMapping(value = "/data/{userId}", method = RequestMethod.GET)
    public CommonResult<Data> getDataByUserId(@PathVariable(name = "userId") Long userId) throws IOException {
        Data data = dataService.getDataByUserId(userId);
        if (data == null) {
            return CommonResult.failed("Get data failed");
        }
        return CommonResult.success(data);
    }

    @RequestMapping(value = "/plant/{plantId}", method = RequestMethod.GET)
    public CommonResult<Plant> getPlantNameByPlantId(@PathVariable(name = "plantId") Long plantId) throws IOException {
        return CommonResult.success(plantService.getPlantByPlantId(plantId));
    }

    @RequestMapping(value = "/data/plant/{userId}", method = RequestMethod.GET)
    public CommonResult<List<Data>> getDataListByUserId(@PathVariable(name = "userId") Long userId) throws IOException {
        return CommonResult.success(dataService.getDataListByUserId(userId));
    }
}
