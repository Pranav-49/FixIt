package com.example.userService.controller;

import com.example.userService.repository.UploadMetadataRepository;
import com.example.userService.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UploadMetadataRepository uploadRepo;

    public UserController(UserService userService, UploadMetadataRepository uploadRepo){
        this.userService = userService;
        this.uploadRepo = uploadRepo;
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(@AuthenticationPrincipal UserDetails userDetails){
        if (userDetails == null) return ResponseEntity.status(401).body("Unauthorized");
        return userService.findByUsername(userDetails.getUsername())
                .map(u -> ResponseEntity.ok(u))
                .orElse(ResponseEntity.notFound().build());
    }

    // Admin endpoint example: list uploads pending approval
    @GetMapping("/uploads/pending")
    public ResponseEntity<?> pendingUploads(){
        return ResponseEntity.ok(uploadRepo.findByApproved(false));
    }
}
