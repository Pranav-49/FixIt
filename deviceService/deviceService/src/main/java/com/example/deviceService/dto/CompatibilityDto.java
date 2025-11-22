package com.example.deviceService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompatibilityDto {

    private SsdCompatibilityDto ssd;
    private RamCompatibilityDto ram;
    private BatteryCompatibilityDto battery;
}
