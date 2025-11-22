package com.example.guideService.controller;

import com.example.guideService.dto.GuideRequestDTO;
import com.example.guideService.dto.GuideResponseDTO;
import com.example.guideService.dto.ImageAttachRequestDTO;
import com.example.guideService.mapper.GuideMapper;
import com.example.guideService.model.Guide;
import com.example.guideService.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guides")
@RequiredArgsConstructor
public class GuideController {

    private final GuideService guideService;
    private final GuideMapper guideMapper;

    @PostMapping
    public ResponseEntity<GuideResponseDTO> createGuide(@RequestBody GuideRequestDTO dto) {

        Guide guide = guideMapper.toEntity(dto);

        Guide savedGuide = guideService.createGuide(guide);

        GuideResponseDTO response = guideMapper.toDTO(savedGuide);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuideResponseDTO> updateGuide(
            @PathVariable String id,
            @RequestBody GuideRequestDTO dto) {

        Guide updatedGuide = guideMapper.toEntity(dto);
        Guide updated = guideService.updateGuide(id, updatedGuide);

        return ResponseEntity.ok(guideMapper.toDTO(updated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuideResponseDTO> getGuide(@PathVariable String id) {
        Guide g = guideService.getGuide(id);
        return ResponseEntity.ok(guideMapper.toDTO(g));
    }

    @GetMapping("/device/{deviceId}")
    public ResponseEntity<List<GuideResponseDTO>> getByDevice(@PathVariable String deviceId) {
        List<Guide> guides = guideService.getGuidesByDevice(deviceId);
        return ResponseEntity.ok(guideMapper.toDTOList(guides));
    }

    @GetMapping("/type/{repairType}")
    public ResponseEntity<List<GuideResponseDTO>> getByType(@PathVariable String repairType) {
        List<Guide> guides = guideService.getByRepairType(repairType);
        return ResponseEntity.ok(guideMapper.toDTOList(guides));
    }

    @GetMapping
    public ResponseEntity<List<GuideResponseDTO>> getAll() {
        return ResponseEntity.ok(guideMapper.toDTOList(guideService.getAll()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuide(@PathVariable String id) {
        guideService.deleteGuide(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{guideId}/steps/{stepNumber}/images")
    public ResponseEntity<String> attachImage(
            @PathVariable String guideId,
            @PathVariable int stepNumber,
            @RequestBody ImageAttachRequestDTO dto) {

        guideService.attachImageToStep(
                guideId,
                stepNumber,
                dto.getImageId(),
                dto.getUploaderUserId()
        );

        return ResponseEntity.ok("Image attached successfully!");
    }
}