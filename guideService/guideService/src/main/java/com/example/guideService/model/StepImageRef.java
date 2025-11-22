package com.example.guideService.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StepImageRef {

    private String imageId;     // from Image Service
    private String uploaderUserId;
    private boolean verified;   // admin-approved
}