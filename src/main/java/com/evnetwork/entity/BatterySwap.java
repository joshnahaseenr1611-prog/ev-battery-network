package com.evnetwork.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BatterySwap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long batteryId;
    private String fleetName;
    private String driverName;
    private String stationLocation;
    private Double stateOfHealth;
    private Double swapAmount;
    private String swapStatus;
    private String recyclingStatus;

    public BatterySwap() {
    }

    public Long getId() {
        return id;
    }

    public Long getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(Long batteryId) {
        this.batteryId = batteryId;
    }

    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getStationLocation() {
        return stationLocation;
    }

    public void setStationLocation(String stationLocation) {
        this.stationLocation = stationLocation;
    }

    public Double getStateOfHealth() {
        return stateOfHealth;
    }

    public void setStateOfHealth(Double stateOfHealth) {
        this.stateOfHealth = stateOfHealth;
    }

    public Double getSwapAmount() {
        return swapAmount;
    }

    public void setSwapAmount(Double swapAmount) {
        this.swapAmount = swapAmount;
    }

    public String getSwapStatus() {
        return swapStatus;
    }

    public void setSwapStatus(String swapStatus) {
        this.swapStatus = swapStatus;
    }

    public String getRecyclingStatus() {
        return recyclingStatus;
    }

    public void setRecyclingStatus(String recyclingStatus) {
        this.recyclingStatus = recyclingStatus;
    }
}