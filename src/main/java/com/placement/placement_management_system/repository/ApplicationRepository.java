package com.placement.placement_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.placement_management_system.entity.Application;

public  interface ApplicationRepository extends JpaRepository<Application, Integer> {
    boolean existsByStudentIdAndJobId(int studentId, int jobId);
}
