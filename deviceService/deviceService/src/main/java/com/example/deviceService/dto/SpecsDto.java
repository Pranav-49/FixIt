package com.example.deviceService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecsDto {

    private CpuDto cpu;
    private RamInfoDto ram;
    private StorageInfoDto storage;
    private BatteryInfoDto battery;
}
