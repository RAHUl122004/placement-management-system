package com.placement.placement_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.placement.placement_management_system.entity.Application;
import com.placement.placement_management_system.service.ApplicationService;

import jakarta.validation.Valid;

import com.placement.placement_management_system.dto.ApplicationRequestDTO;
import com.placement.placement_management_system.dto.ApplicationResponseDTO;

@RestController
public class ApplicationController {

    private ApplicationService service;

    public ApplicationController(ApplicationService service) {
        this.service = service;
    }

  @PostMapping("/applications")
public ApplicationResponseDTO addApplication(@Valid @RequestBody ApplicationRequestDTO request) {
    return service.applyForJob(request);
}

    @GetMapping("/applications")
    public List<Application> getApplications() {
        return service.getAllApplications();
    }
}
