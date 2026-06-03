package com.placement.placement_management_system.dto;

public class JobResponseDTO {

    private int id;
    private String title;
    private String location;
    private double salary;
    private String requiredSkills;
    private String companyName;

    public JobResponseDTO() {
    }

    public JobResponseDTO(int id, String title, String location,
                          double salary, String requiredSkills,
                          String companyName) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.salary = salary;
        this.requiredSkills = requiredSkills;
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public double getSalary() {
        return salary;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public String getCompanyName() {
        return companyName;
    }
}
