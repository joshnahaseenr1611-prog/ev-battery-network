package com.evnetwork.controller;

import com.evnetwork.entity.BatterySwap;
import com.evnetwork.service.BatterySwapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batteries/swaps")
public class BatterySwapController {

    private final BatterySwapService batterySwapService;

    public BatterySwapController(BatterySwapService batterySwapService) {
        this.batterySwapService = batterySwapService;
    }

    @PostMapping
    public ResponseEntity<BatterySwap> processSwap(
            @RequestBody BatterySwap swap) {

        return ResponseEntity.ok(
                batterySwapService.processSwap(swap)
        );
    }

    @GetMapping
    public ResponseEntity<List<BatterySwap>> getAllSwaps() {
        return ResponseEntity.ok(
                batterySwapService.getAllSwaps()
        );
    }
}