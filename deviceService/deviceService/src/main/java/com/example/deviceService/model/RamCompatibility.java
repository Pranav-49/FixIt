package com.example.deviceService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RamCompatibility {
    private String supportedTypes;       // DDR3 / DDR4 / DDR5
    private int maxCapacity;
    private int maxSpeed;
}
