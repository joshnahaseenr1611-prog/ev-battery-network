package com.evnetwork.service;

import com.evnetwork.entity.BatterySwap;
import com.evnetwork.repository.BatterySwapRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatterySwapService {

    private final BatterySwapRepository batterySwapRepository;

    public BatterySwapService(BatterySwapRepository batterySwapRepository) {
        this.batterySwapRepository = batterySwapRepository;
    }

    public BatterySwap processSwap(BatterySwap swap) {

        if (swap.getStateOfHealth() < 70) {
            swap.setSwapStatus("REJECTED");
            swap.setRecyclingStatus("ROUTED_TO_RECYCLING");
        } else {
            swap.setSwapStatus("SWAP_COMPLETED");
            swap.setRecyclingStatus("NOT_REQUIRED");
        }

        return batterySwapRepository.save(swap);
    }

    public List<BatterySwap> getAllSwaps() {
        return batterySwapRepository.findAll();
    }
}