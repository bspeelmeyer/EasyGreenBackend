package com.pp1.easygreen.entity;

public class Plant {
    private Long id;
    private String plantName;
    private String description;

    // constructors
    public Plant() {}

    public Plant(Long id, String plantName, String description) {
        this.id = id;
        this.plantName = plantName;
        this.description = description;
    }

    public Plant(String plantName, String description) {
        this.plantName = plantName;
        this.description = description;
    }

    // getter and setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
