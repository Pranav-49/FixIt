package com.example.deviceService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SsdCompatibilityDto {

    private boolean supportsNVMe;
    private boolean supportsSataM2;
    private boolean supports2_5InchSata;
}