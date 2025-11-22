package com.example.deviceService.dto;


import com.example.deviceService.model.*;

public class DeviceMapper {

    // Convert Request DTO → Entity
    public static Device toEntity(DeviceRequestDto dto) {
        return Device.builder()
                .brand(dto.getBrand())
                .model(dto.getModel())
                .deviceType(dto.getDeviceType())
                .imageUrl(dto.getImageUrl())
                .specs(toSpecsEntity(dto.getSpecs()))
                .compatibility(toCompatibilityEntity(dto.getCompatibility()))
                .build();
    }

    // Convert Entity → Response DTO
    public static DeviceResponseDto toDto(Device device) {
        return DeviceResponseDto.builder()
                .id(device.getId())
                .brand(device.getBrand())
                .model(device.getModel())
                .deviceType(device.getDeviceType())
                .imageUrl(device.getImageUrl())
                .specs(toSpecsDto(device.getSpecs()))
                .compatibility(toCompatibilityDto(device.getCompatibility()))
                .build();
    }

    // SPECS MAPPING
    private static Specs toSpecsEntity(SpecsDto dto) {
        return Specs.builder()
                .cpu(toCpuEntity(dto.getCpu()))
                .ram(toRamEntity(dto.getRam()))
                .storage(toStorageEntity(dto.getStorage()))
                .battery(toBatteryEntity(dto.getBattery()))
                .build();
    }

    private static SpecsDto toSpecsDto(Specs specs) {
        return SpecsDto.builder()
                .cpu(toCpuDto(specs.getCpu()))
                .ram(toRamDto(specs.getRam()))
                .storage(toStorageDto(specs.getStorage()))
                .battery(toBatteryDto(specs.getBattery()))
                .build();
    }

    // CPU
    private static Cpu toCpuEntity(CpuDto dto) {
        return Cpu.builder()
                .manufacturer(dto.getManufacturer())
                .model(dto.getModel())
                .cores(dto.getCores())
                .threads(dto.getThreads())
                .build();
    }

    private static CpuDto toCpuDto(Cpu cpu) {
        return CpuDto.builder()
                .manufacturer(cpu.getManufacturer())
                .model(cpu.getModel())
                .cores(cpu.getCores())
                .threads(cpu.getThreads())
                .build();
    }

    // RAM
    private static RamInfo toRamEntity(RamInfoDto dto) {
        return RamInfo.builder()
                .maxCapacity(dto.getMaxCapacity())
                .type(dto.getType())
                .slotCount(dto.getSlotCount())
                .currentInstalled(dto.getCurrentInstalled())
                .speed(dto.getSpeed())
                .build();
    }

    private static RamInfoDto toRamDto(RamInfo ram) {
        return RamInfoDto.builder()
                .maxCapacity(ram.getMaxCapacity())
                .type(ram.getType())
                .slotCount(ram.getSlotCount())
                .currentInstalled(ram.getCurrentInstalled())
                .speed(ram.getSpeed())
                .build();
    }

    // STORAGE
    private static StorageInfo toStorageEntity(StorageInfoDto dto) {
        return StorageInfo.builder()
                .hasM2Slot(dto.isHasM2Slot())
                .m2Type(dto.getM2Type())
                .hasSataSlot(dto.isHasSataSlot())
                .build();
    }

    private static StorageInfoDto toStorageDto(StorageInfo storage) {
        return StorageInfoDto.builder()
                .hasM2Slot(storage.isHasM2Slot())
                .m2Type(storage.getM2Type())
                .hasSataSlot(storage.isHasSataSlot())
                .build();
    }

    // BATTERY
    private static BatteryInfo toBatteryEntity(BatteryInfoDto dto) {
        return BatteryInfo.builder()
                .modelNumber(dto.getModelNumber())
                .capacityWh(dto.getCapacityWh())
                .build();
    }

    private static BatteryInfoDto toBatteryDto(BatteryInfo info) {
        return BatteryInfoDto.builder()
                .modelNumber(info.getModelNumber())
                .capacityWh(info.getCapacityWh())
                .build();
    }

    // COMPATIBILITY
    private static Compatibility toCompatibilityEntity(CompatibilityDto dto) {
        return Compatibility.builder()
                .ssd(toSsdEntity(dto.getSsd()))
                .ram(toRamCompEntity(dto.getRam()))
                .battery(toBatteryCompEntity(dto.getBattery()))
                .build();
    }

    private static CompatibilityDto toCompatibilityDto(Compatibility comp) {
        return CompatibilityDto.builder()
                .ssd(toSsdDto(comp.getSsd()))
                .ram(toRamCompDto(comp.getRam()))
                .battery(toBatteryCompDto(comp.getBattery()))
                .build();
    }

    private static SsdCompatibility toSsdEntity(SsdCompatibilityDto dto) {
        return SsdCompatibility.builder()
                .supportsNVMe(dto.isSupportsNVMe())
                .supportsSataM2(dto.isSupportsSataM2())
                .supports2_5InchSata(dto.isSupports2_5InchSata())
                .build();
    }

    private static SsdCompatibilityDto toSsdDto(SsdCompatibility ssd) {
        return SsdCompatibilityDto.builder()
                .supportsNVMe(ssd.isSupportsNVMe())
                .supportsSataM2(ssd.isSupportsSataM2())
                .supports2_5InchSata(ssd.isSupports2_5InchSata())
                .build();
    }

    private static RamCompatibility toRamCompEntity(RamCompatibilityDto dto) {
        return RamCompatibility.builder()
                .supportedTypes(dto.getSupportedTypes())
                .maxCapacity(dto.getMaxCapacity())
                .maxSpeed(dto.getMaxSpeed())
                .build();
    }

    private static RamCompatibilityDto toRamCompDto(RamCompatibility comp) {
        return RamCompatibilityDto.builder()
                .supportedTypes(comp.getSupportedTypes())
                .maxCapacity(comp.getMaxCapacity())
                .maxSpeed(comp.getMaxSpeed())
                .build();
    }

    private static BatteryCompatibility toBatteryCompEntity(BatteryCompatibilityDto dto) {
        return BatteryCompatibility.builder()
                .compatibleModel(dto.getCompatibleModel())
                .build();
    }

    private static BatteryCompatibilityDto toBatteryCompDto(BatteryCompatibility comp) {
        return BatteryCompatibilityDto.builder()
                .compatibleModel(comp.getCompatibleModel())
                .build();
    }
}
