package com.example.guideService.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "guides")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guide {

    @Id
    private String id;

    private String deviceId;       // Reference to Device Service

    private String repairType;     // "Add SSD", "Replace Battery"

    private String title;

    private String summary;

    private int version;

    private List<GuideStep> steps;   // Embedded documents
}