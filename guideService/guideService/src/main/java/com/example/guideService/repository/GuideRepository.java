package com.example.guideService.repository;


import com.example.guideService.model.Guide;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GuideRepository extends MongoRepository<Guide, String> {

    List<Guide> findByDeviceId(String deviceId);

    List<Guide> findByRepairTypeIgnoreCase(String repairType);
}