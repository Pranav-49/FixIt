package com.example.userService.repository;

import com.example.userService.entity.UploadMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UploadMetadataRepository extends JpaRepository<UploadMetadata, Long> {
    List<UploadMetadata> findByUserId(Long userId);
    List<UploadMetadata> findByApproved(Boolean approved);
}
