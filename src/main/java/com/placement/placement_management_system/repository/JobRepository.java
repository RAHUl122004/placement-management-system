package com.placement.placement_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.placement.placement_management_system.entity.Job;

public  interface JobRepository extends JpaRepository<Job, Integer> {
    
    List<Job> findByLocation(String location);
}
