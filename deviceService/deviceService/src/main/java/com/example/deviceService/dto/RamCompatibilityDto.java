package com.example.deviceService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RamCompatibilityDto {

    private String supportedTypes;
    private int maxCapacity;
    private int maxSpeed;
}
