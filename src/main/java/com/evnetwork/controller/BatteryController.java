package com.evnetwork.controller;

import com.evnetwork.entity.Battery;
import com.evnetwork.service.BatteryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batteries")
public class BatteryController {

    private final BatteryService batteryService;

    public BatteryController(BatteryService batteryService) {
        this.batteryService = batteryService;
    }

    @PostMapping("/packs")
    public ResponseEntity<Battery> addBattery(@RequestBody Battery battery) {
        Battery savedBattery = batteryService.addBattery(battery);
        return ResponseEntity.ok(savedBattery);
    }

    @GetMapping("/packs")
    public ResponseEntity<List<Battery>> getAllBatteries() {
        return ResponseEntity.ok(batteryService.getAllBatteries());
    }

    @GetMapping("/packs/{id}")
    public ResponseEntity<Battery> getBatteryById(@PathVariable Long id) {
        return batteryService.getBatteryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/packs/{id}")
    public ResponseEntity<Void> deleteBattery(@PathVariable Long id) {
        batteryService.deleteBattery(id);
        return ResponseEntity.noContent().build();
    }
}