package com.pp1.easygreen.controller;

import com.alibaba.fastjson.JSONObject;
import com.pp1.easygreen.entity.Plant;
import com.pp1.easygreen.service.PlantService;
import com.pp1.easygreen.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PlantController {
    @Autowired
    private PlantService plantService;

    @RequestMapping(value = "/plant/{plantId}", method = RequestMethod.GET)
    public CommonResult<Plant> getPlantNameByPlantId(@PathVariable(name = "plantId") Long plantId) throws IOException {
        return CommonResult.success(plantService.getPlantByPlantId(plantId));
    }

    @RequestMapping(value = "/plant/delete-plant/{id}", method = RequestMethod.GET)
    public CommonResult<Long> deletePlantBySelected(@PathVariable(name = "id") Long id) throws IOException {
        boolean plant = plantService.deletePlant(id);
        if (plant == true) {
            return CommonResult.success(id);
        } else {
            return CommonResult.validateFailed("Delete unsuccessful");
        }
    }

    @RequestMapping(value = "/plant", method = RequestMethod.POST)
    public CommonResult<Plant> createPlant(@RequestBody JSONObject param) throws IOException {
        Plant plant = param.toJavaObject(Plant.class);
        plant = new Plant(
                param.getString("plantName"),
                param.getString("description")
        );
        plant = plantService.createPlant(plant);
        if (plant == null) {
            return CommonResult.failed("Fail to create a plant");
        }
        if (plant.getId() == -1) {
            return CommonResult.failed("This plant is already existed");
        }
        return CommonResult.success(plant);
    }

    @RequestMapping(value = "/plant", method = RequestMethod.PUT)
    public CommonResult<String> updatePlant(@RequestBody JSONObject param) throws IOException {
        Plant plant = new Plant(param.getLong("id"), param.getString("plantName"), param.getString("description"));
        plantService.updatePlant(plant);
        return CommonResult.success("Plant has been updated");
    }
}
