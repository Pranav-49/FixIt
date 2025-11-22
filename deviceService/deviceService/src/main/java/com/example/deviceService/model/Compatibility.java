package com.example.deviceService.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compatibility {

    private SsdCompatibility ssd;
    private RamCompatibility ram;
    private BatteryCompatibility battery;

}
