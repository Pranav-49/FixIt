package com.example.guideService.mapper;


import com.example.guideService.dto.GuideRequestDTO;
import com.example.guideService.dto.GuideResponseDTO;
import com.example.guideService.dto.GuideStepDTO;
import com.example.guideService.dto.StepImageDTO;
import com.example.guideService.model.Guide;
import com.example.guideService.model.GuideStep;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GuideMapper {

    // -----------------------------
    // DTO → ENTITY (Request → Model)
    // -----------------------------
    public Guide toEntity(GuideRequestDTO dto) {
        Guide guide = new Guide();
        guide.setDeviceId(dto.getDeviceId());
        guide.setRepairType(dto.getRepairType());
        guide.setTitle(dto.getTitle());

        // Steps: protect against null dto.getSteps()
        List<GuideStepDTO> stepDtos = dto.getSteps() == null ? Collections.emptyList() : dto.getSteps();

        List<GuideStep> steps = stepDtos.stream()
                .map(stepDto -> GuideStep.builder()
                        .stepNumber(stepDto.getStepNumber())
                        .description(stepDto.getDescription())
                        .images(new ArrayList<>()) // empty mutable list initially
                        .build())
                .collect(Collectors.toList());

        guide.setSteps(steps);
        return guide;
    }

    // -----------------------------
    // ENTITY → DTO (Model → Response)
    // -----------------------------
    public GuideResponseDTO toDTO(Guide guide) {
        GuideResponseDTO dto = new GuideResponseDTO();
        dto.setId(guide.getId());
        dto.setDeviceId(guide.getDeviceId());
        dto.setRepairType(guide.getRepairType());
        dto.setTitle(guide.getTitle());
        dto.setVersion(guide.getVersion());

        // Steps: protect against null guide.getSteps()
        List<GuideStep> guideSteps = guide.getSteps() == null ? Collections.emptyList() : guide.getSteps();

        dto.setSteps(guideSteps.stream()
                .map(step -> new GuideStepDTO(
                        step.getStepNumber(),
                        step.getDescription(),
                        // protect against null images
                        (step.getImages() == null ? Collections.<StepImageDTO>emptyList() :
                                step.getImages().stream()
                                        .map(img -> new StepImageDTO(
                                                img.getImageId(),
                                                img.getUploaderUserId(),
                                                img.isVerified()
                                        ))
                                        .collect(Collectors.toList()))
                ))
                .collect(Collectors.toList()));

        return dto;
    }

    // List mapping
    public List<GuideResponseDTO> toDTOList(List<Guide> guides) {
        if (guides == null) return Collections.emptyList();
        return guides.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}