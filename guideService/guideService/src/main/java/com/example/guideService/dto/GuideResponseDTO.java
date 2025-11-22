package com.example.guideService.dto;

import lombok.Data;
import java.util.List;

@Data
public class GuideResponseDTO {

    private String id;
    private String deviceId;
    private String repairType;
    private String title;
    private int version;

    private List<GuideStepDTO> steps;
}

