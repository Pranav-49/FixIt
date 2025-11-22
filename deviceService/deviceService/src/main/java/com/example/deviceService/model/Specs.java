package com.example.deviceService.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Specs {

    private Cpu cpu;
    private RamInfo ram;
    private StorageInfo storage;
    private BatteryInfo battery;
}
