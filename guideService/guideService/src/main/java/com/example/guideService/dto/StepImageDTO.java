package com.example.guideService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StepImageDTO {
    private String imageId;
    private String uploaderUserId;
    private boolean verified;
}
