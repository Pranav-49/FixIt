package com.example.deviceService.repository;

import com.example.deviceService.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends MongoRepository<Device, String> {

    List<Device> findByBrandIgnoreCase(String brand);

    Optional<Device> findByModelIgnoreCase(String model);
}