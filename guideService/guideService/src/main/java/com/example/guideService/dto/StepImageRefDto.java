package com.example.guideService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StepImageRefDto {
    private String imageId;
    private String uploaderUserId;
    private boolean verified;
}
