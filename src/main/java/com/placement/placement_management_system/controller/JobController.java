package com.placement.placement_management_system.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.placement.placement_management_system.dto.JobResponseDTO;
import com.placement.placement_management_system.entity.Job;
import com.placement.placement_management_system.service.JobService;

import jakarta.validation.Valid;

@RestController
public class JobController {

    private JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @PostMapping("/jobs")
    public Job addJob(@Valid @RequestBody Job job) {
        return service.saveJob(job);
    }

    @GetMapping("/jobs")
    public List<JobResponseDTO> getJobs() {

        return service.getAllJobs()
                .stream()
                .map(service::getJobDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/jobs/page")
    public Page<Job> getJobsByPage(@RequestParam int page,
                                   @RequestParam int size) {
        return service.getJobsByPage(page, size);
    }

    @GetMapping("/jobs/salary")
    public List<Job> getJobsSortedBySalary() {
        return service.getJobsSortedBySalary();
    }

    @GetMapping("/jobs/location")
    public List<Job> getJobsByLocation(@RequestParam String location) {
        return service.getJobsByLocation(location);
    }
}