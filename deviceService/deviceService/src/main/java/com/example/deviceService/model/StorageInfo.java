package com.example.deviceService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StorageInfo {
    private boolean hasM2Slot;        // true/false
    private String m2Type;            // NVMe, SATA, None
    private boolean hasSataSlot;
}
