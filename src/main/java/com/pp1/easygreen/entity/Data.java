package com.pp1.easygreen.entity;

import java.util.Date;

public class Data {
    private Long id;
    private Long plantId;
    private Long userId;
    private String temperature;
    private String humidity;
    private String soilMoisture;
    private String lightIntensity;
    private Date collectTime;
    private String plantName;

    public Data() {}

    public Data(Long plantId, Long userId, String temperature, String humidity, String soilMoisture, String lightIntensity, Long collectTime) {
        this.plantId = plantId;
        this.userId = userId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.soilMoisture = soilMoisture;
        this.lightIntensity = lightIntensity;
        this.collectTime = new Date(collectTime);
    }

    public Data(Long id, String temperature, String humidity, String soilMoisture, String lightIntensity, Long collectTime) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.soilMoisture = soilMoisture;
        this.lightIntensity = lightIntensity;
        this.collectTime = new Date(collectTime);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(String soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public String getLightIntensity() {
        return lightIntensity;
    }

    public void setLightIntensity(String lightIntensity) {
        this.lightIntensity = lightIntensity;
    }

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
}
