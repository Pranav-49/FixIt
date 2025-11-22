package com.example.userService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "uploaded_images")
@Getter
@Setter
@AllArgsConstructor
public class UploadMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable=false)
    private Long userId;

    @Column(name = "file_name", nullable=false)
    private String fileName;

    @Column(name = "file_path", nullable=false)
    private String filePath;

    @Column(name = "device_model")
    private String deviceModel;

    @Column(name = "guide_id")
    private String guideId;

    @Column(name = "step_number")
    private Integer stepNumber;

    @Column(name = "approved")
    private Boolean approved = false;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    public UploadMetadata(){

    }

}