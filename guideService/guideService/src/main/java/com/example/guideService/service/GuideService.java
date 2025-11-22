package com.example.guideService.service;

import com.example.guideService.model.Guide;

import java.util.List;

public interface GuideService {

    Guide createGuide(Guide guide);

    Guide updateGuide(String id, Guide updated);

    Guide getGuide(String id);

    List<Guide> getGuidesByDevice(String deviceId);

    List<Guide> getByRepairType(String repairType);

    List<Guide> getAll();

    void deleteGuide(String id);

    void attachImageToStep(String guideId, int stepNumber, String imageId, String uploaderId);
}