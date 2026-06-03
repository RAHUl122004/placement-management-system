
package com.placement.placement_management_system.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.placement.placement_management_system.dto.ApplicationRequestDTO;
import com.placement.placement_management_system.dto.ApplicationResponseDTO;
import com.placement.placement_management_system.entity.Application;
import com.placement.placement_management_system.entity.Job;
import com.placement.placement_management_system.entity.Student;
import com.placement.placement_management_system.exception.DuplicateApplicationException;
import com.placement.placement_management_system.exception.ResourceNotFoundException;
import com.placement.placement_management_system.repository.ApplicationRepository;
import com.placement.placement_management_system.repository.JobRepository;
import com.placement.placement_management_system.repository.StudentRepository;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository;
    private StudentRepository studentRepository;
    private JobRepository jobRepository;

    public ApplicationService(ApplicationRepository applicationRepository,
                              StudentRepository studentRepository,
                              JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.studentRepository = studentRepository;
        this.jobRepository = jobRepository;
    }

    public ApplicationResponseDTO applyForJob(ApplicationRequestDTO request) {

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new ResourceNotFoundException("Job not found"));

        boolean alreadyApplied =
                applicationRepository.existsByStudentIdAndJobId(
                        request.getStudentId(),
                        request.getJobId()
                );

        if (alreadyApplied) {
            throw new DuplicateApplicationException("Student has already applied for this job");
        }

        Application application = new Application();
        application.setStatus("APPLIED");
        application.setStudent(student);
        application.setJob(job);
        application.setAppliedAt(LocalDateTime.now());

        Application savedApplication = applicationRepository.save(application);

        return getApplicationDTO(savedApplication);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public ApplicationResponseDTO getApplicationDTO(Application application) {

        return new ApplicationResponseDTO(
                application.getId(),
                application.getStatus(),
                application.getStudent().getName(),
                application.getJob().getTitle(),
                application.getJob().getCompany().getName()
        );
    }
}