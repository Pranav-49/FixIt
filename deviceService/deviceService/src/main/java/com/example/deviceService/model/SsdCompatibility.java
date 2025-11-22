package com.example.deviceService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SsdCompatibility {
    private boolean supportsNVMe;
    private boolean supportsSataM2;
    private boolean supports2_5InchSata;
}