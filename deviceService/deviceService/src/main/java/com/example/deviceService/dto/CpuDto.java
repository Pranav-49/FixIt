package com.example.deviceService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CpuDto {
    private String manufacturer;
    private String model;
    private int cores;
    private int threads;
}
