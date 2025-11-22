package com.example.deviceService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RamInfoDto {

    private int maxCapacity;
    private String type;
    private int slotCount;
    private int currentInstalled;
    private int speed;
}
