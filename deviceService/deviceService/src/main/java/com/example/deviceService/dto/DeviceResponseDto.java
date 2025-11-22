package com.example.deviceService.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceResponseDto {

    private String id;
    private String brand;
    private String model;
    private String deviceType;

    private SpecsDto specs;
    private CompatibilityDto compatibility;

    private String imageUrl;
}
