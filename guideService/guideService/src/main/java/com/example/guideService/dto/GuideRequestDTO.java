package com.example.guideService.dto;

import lombok.Data;

import java.util.List;

@Data
public class GuideRequestDTO {
    private String deviceId;
    private String repairType;
    private String title;

    private List<GuideStepDTO> steps;
}
