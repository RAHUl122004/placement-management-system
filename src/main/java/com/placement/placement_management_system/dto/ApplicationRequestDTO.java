package com.placement.placement_management_system.dto;

import jakarta.validation.constraints.Min;

public class ApplicationRequestDTO {
     @Min(1)
    private int studentId;

     @Min(1)
    private int jobId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}
