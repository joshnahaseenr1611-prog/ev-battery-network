package com.evnetwork.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batteryCode;
    private String model;
    private Double capacity;
    private Double stateOfHealth;
    private String status;
    private String stationLocation;

    public Battery() {
    }

    public Long getId() {
        return id;
    }

    public String getBatteryCode() {
        return batteryCode;
    }

    public void setBatteryCode(String batteryCode) {
        this.batteryCode = batteryCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getStateOfHealth() {
        return stateOfHealth;
    }

    public void setStateOfHealth(Double stateOfHealth) {
        this.stateOfHealth = stateOfHealth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStationLocation() {
        return stationLocation;
    }

    public void setStationLocation(String stationLocation) {
        this.stationLocation = stationLocation;
    }
}