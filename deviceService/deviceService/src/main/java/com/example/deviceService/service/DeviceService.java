package com.example.deviceService.service;

import com.example.deviceService.model.Device;

import java.util.List;

public interface DeviceService {

    Device saveDevice(Device device);

    Device getById(String id);

    List<Device> searchByBrand(String brand);

    Device searchByModel(String model);

    List<Device> getAll();

    void deleteById(String id);
}
