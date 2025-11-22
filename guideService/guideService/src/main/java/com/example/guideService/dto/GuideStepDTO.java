package com.example.guideService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuideStepDTO {
    private int stepNumber;
    private String description;

    private List<StepImageDTO> images;
}