package com.example.deviceService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StorageInfoDto {

    private boolean hasM2Slot;
    private String m2Type;
    private boolean hasSataSlot;
}