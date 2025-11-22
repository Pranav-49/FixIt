package com.example.guideService.service;


import com.example.guideService.model.Guide;
import com.example.guideService.model.GuideStep;
import com.example.guideService.model.StepImageRef;
import com.example.guideService.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GuideServiceImpl implements GuideService {

    private final GuideRepository guideRepository;

    @Override
    public Guide createGuide(Guide guide) {
        guide.setVersion(1);   // initial version
        log.info("Creating guide: {}", guide.getTitle());
        return guideRepository.save(guide);
    }

    @Override
    public Guide updateGuide(String id, Guide updated) {
        Guide existing = guideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guide not found: " + id));

        updated.setId(id);
        updated.setVersion(existing.getVersion() + 1); // bump version

        log.info("Updating guide {} → new version {}", id, updated.getVersion());
        return guideRepository.save(updated);
    }

    @Override
    public Guide getGuide(String id) {
        return guideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guide not found: " + id));
    }

    @Override
    public List<Guide> getGuidesByDevice(String deviceId) {
        return guideRepository.findByDeviceId(deviceId);
    }

    @Override
    public List<Guide> getByRepairType(String repairType) {
        return guideRepository.findByRepairTypeIgnoreCase(repairType);
    }

    @Override
    public List<Guide> getAll() {
        return guideRepository.findAll();
    }

    @Override
    public void deleteGuide(String id) {
        if (!guideRepository.existsById(id)) {
            throw new RuntimeException("Guide not found: " + id);
        }
        guideRepository.deleteById(id);
        log.info("Deleted guide: {}", id);
    }

    @Override
    public void attachImageToStep(String guideId, int stepNumber, String imageId, String uploaderId) {
        Guide guide = guideRepository.findById(guideId)
                .orElseThrow(() -> new RuntimeException("Guide not found: " + guideId));

        GuideStep targetStep = guide.getSteps().stream()
                .filter(step -> step.getStepNumber() == stepNumber)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Step not found: " + stepNumber));

        StepImageRef imageRef = StepImageRef.builder()
                .imageId(imageId)
                .uploaderUserId(uploaderId)
                .verified(false) // admin will verify later
                .build();

        targetStep.getImages().add(imageRef);

        // bump version because step changed
        guide.setVersion(guide.getVersion() + 1);

        guideRepository.save(guide);

        log.info("Image {} added to guide {} step {}", imageId, guideId, stepNumber);
    }
}
