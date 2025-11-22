package com.example.guideService.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuideStep {

    private int stepNumber;

    private String description;       // main step text

    private String aiEnhancedText;    // AI refined text (optional)

    private List<StepImageRef> images;  // references only
}
