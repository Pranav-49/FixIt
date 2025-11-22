package com.example.deviceService.controller;


import com.example.deviceService.dto.DeviceMapper;
import com.example.deviceService.dto.DeviceRequestDto;
import com.example.deviceService.dto.DeviceResponseDto;
import com.example.deviceService.model.Device;
import com.example.deviceService.service.DeviceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/device")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity<DeviceResponseDto> createDevice(@Valid @RequestBody DeviceRequestDto request) {
        Device entity = DeviceMapper.toEntity(request);
        Device saved = deviceService.saveDevice(entity);
        DeviceResponseDto response = DeviceMapper.toDto(saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceResponseDto> updateDevice(
            @PathVariable String id,
            @Valid @RequestBody DeviceRequestDto request) {

        Device existing = deviceService.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        // map request -> entity but keep id
        Device toUpdate = DeviceMapper.toEntity(request);
        toUpdate.setId(id);

        Device updated = deviceService.saveDevice(toUpdate);
        return ResponseEntity.ok(DeviceMapper.toDto(updated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceResponseDto> getById(@PathVariable String id) {
        Device d = deviceService.getById(id);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(DeviceMapper.toDto(d));
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<DeviceResponseDto> findByModel(@PathVariable String model) {
        Device d = deviceService.searchByModel(model);
        if (d == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(DeviceMapper.toDto(d));
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<DeviceResponseDto>> findByBrand(@PathVariable String brand) {
        List<Device> list = deviceService.searchByBrand(brand);
        List<DeviceResponseDto> dto = list.stream().map(DeviceMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<DeviceResponseDto>> search(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String ramType,
            @RequestParam(required = false) Boolean nvme,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        List<Device> all = deviceService.getAll();

        List<Device> filtered = all.stream()
                .filter(d -> brand == null || d.getBrand().equalsIgnoreCase(brand))
                .filter(d -> model == null || d.getModel().equalsIgnoreCase(model))
                .filter(d -> ramType == null || (d.getSpecs() != null && d.getSpecs().getRam() != null &&
                        ramType.equalsIgnoreCase(d.getSpecs().getRam().getType())))
                .filter(d -> nvme == null || (d.getCompatibility() != null && d.getCompatibility().getSsd() != null &&
                        Boolean.valueOf(nvme).equals(d.getCompatibility().getSsd().isSupportsNVMe())))
                .collect(Collectors.toList());

        int start = Math.min(page * size, filtered.size());
        int end = Math.min(start + size, filtered.size());
        List<DeviceResponseDto> dtoPage = filtered.subList(start, end).stream()
                .map(DeviceMapper::toDto)
                .collect(Collectors.toList());

        Page<DeviceResponseDto> result = new PageImpl<>(dtoPage, PageRequest.of(page, size), filtered.size());
        return ResponseEntity.ok(result);
    }


    @GetMapping
    public ResponseEntity<List<DeviceResponseDto>> getAll() {
        List<Device> all = deviceService.getAll();
        List<DeviceResponseDto> dto = all.stream().map(DeviceMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        Device d = deviceService.getById(id);
        if (d == null) return ResponseEntity.notFound().build();
        deviceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
