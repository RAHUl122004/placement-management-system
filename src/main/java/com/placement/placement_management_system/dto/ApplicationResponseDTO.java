package com.placement.placement_management_system.dto;

public class ApplicationResponseDTO {

    private int id;
    private String status;
    private String studentName;
    private String jobTitle;
    private String companyName;

    public ApplicationResponseDTO() {
    }

    public ApplicationResponseDTO(int id, String status,
                                  String studentName,
                                  String jobTitle,
                                  String companyName) {
        this.id = id;
        this.status = status;
        this.studentName = studentName;
        this.jobTitle = jobTitle;
        this.companyName = companyName;
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


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
