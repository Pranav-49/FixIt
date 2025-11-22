package com.example.deviceService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeviceRequestDto {

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotBlank
    private String deviceType;

    @NotNull
    private SpecsDto specs;

    @NotNull
    private CompatibilityDto compatibility;

    private String imageUrl;
}