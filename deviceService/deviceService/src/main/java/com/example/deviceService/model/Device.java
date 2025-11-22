package com.example.deviceService.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "devices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {

    @Id
    private String id;

    private String brand;           // Dell, HP, Lenovo
    private String model;           // Inspiron 5567
    private String deviceType;      // Laptop, Desktop, Mobile

    private Specs specs;            // Embedded full hardware specs

    private List<String> supportedRepairs;  // e.g., "Add SSD", "Upgrade RAM"

    private Compatibility compatibility;    // SSD/RAM/Battery mappings

    private String imageUrl;       // optional thumbnail for UI
}