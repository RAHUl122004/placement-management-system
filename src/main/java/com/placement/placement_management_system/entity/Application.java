package com.placement.placement_management_system.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id") // many application one student
    private Student student;

    @ManyToOne
    @JoinColumn(name = "job_id")   // many appliaction 1 job
    private Job job;

    public Application() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    private LocalDateTime appliedAt;
    public LocalDateTime getAppliedAt() {
    return appliedAt;
}

public void setAppliedAt(LocalDateTime appliedAt) {
    this.appliedAt = appliedAt;
}
}