package com.example.guideService.dto;

import lombok.Data;

@Data
public class ImageAttachRequestDTO {
    private String imageId;
    private String uploaderUserId;   // user-service ID
}
