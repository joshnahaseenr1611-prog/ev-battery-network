package com.evnetwork.service;

import com.evnetwork.entity.Battery;
import com.evnetwork.repository.BatteryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatteryService {

    private final BatteryRepository batteryRepository;

    public BatteryService(BatteryRepository batteryRepository) {
        this.batteryRepository = batteryRepository;
    }

    public Battery addBattery(Battery battery) {
        return batteryRepository.save(battery);
    }

    public List<Battery> getAllBatteries() {
        return batteryRepository.findAll();
    }

    public Optional<Battery> getBatteryById(Long id) {
        return batteryRepository.findById(id);
    }

    public void deleteBattery(Long id) {
        batteryRepository.deleteById(id);
    }
}