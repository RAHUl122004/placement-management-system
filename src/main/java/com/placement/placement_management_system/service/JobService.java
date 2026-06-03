package com.placement.placement_management_system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.placement.placement_management_system.dto.JobResponseDTO;
import com.placement.placement_management_system.entity.Job;
import com.placement.placement_management_system.repository.JobRepository;

@Service
public class JobService {

    private JobRepository repository;

    public JobService(JobRepository repository) {
        this.repository = repository;
    }

    public Job saveJob(Job job) {
        return repository.save(job);
    }

    public List<Job> getAllJobs() {
        return repository.findAll();
    }

    public Page<Job> getJobsByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public List<Job> getJobsSortedBySalary() {
        return repository.findAll(Sort.by("salary"));
    }

    public List<Job> getJobsByLocation(String location) {
        return repository.findByLocation(location);
    }

    public JobResponseDTO getJobDTO(Job job) {
        return new JobResponseDTO(
                job.getId(),
                job.getTitle(),
                job.getLocation(),
                job.getSalary(),
                job.getRequiredSkills(),
                job.getCompany().getName()
        );
    }
}
