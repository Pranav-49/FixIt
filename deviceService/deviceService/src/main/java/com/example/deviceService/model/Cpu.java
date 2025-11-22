package com.example.deviceService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cpu {
    private String manufacturer;  // Intel / AMD
    private String model;         // i5-7200U
    private int cores;
    private int threads;
}

