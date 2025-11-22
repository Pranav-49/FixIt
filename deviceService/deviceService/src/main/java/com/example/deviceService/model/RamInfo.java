package com.example.deviceService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RamInfo {
    private int maxCapacity;          // e.g., 32 GB
    private String type;              // DDR3 / DDR4 / DDR5
    private int slotCount;
    private int currentInstalled;     // 8GB
    private int speed;                // MHz
}
