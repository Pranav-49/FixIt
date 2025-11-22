package com.example.deviceService.service;

import com.example.deviceService.model.Device;
import com.example.deviceService.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Override
    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device getById(String id) {
        return deviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Device> getAll() {
        return deviceRepository.findAll();
    }

    @Override
    public List<Device> searchByBrand(String brand) {
        return deviceRepository.findByBrandIgnoreCase(brand);
    }

    @Override
    public Device searchByModel(String model) {
        return deviceRepository.findByModelIgnoreCase(model).orElse(null);
    }

    @Override
    public void deleteById(String id) {
        if (deviceRepository.existsById(id)) {
            deviceRepository.deleteById(id);
        }
    }
}
