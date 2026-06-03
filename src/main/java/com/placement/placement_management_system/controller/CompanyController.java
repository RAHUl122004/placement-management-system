package com.placement.placement_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.placement.placement_management_system.entity.Company;
import com.placement.placement_management_system.service.CompanyService;

import jakarta.validation.Valid;

@RestController
public class CompanyController {

    private CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping("/companies")
    public Company addCompany( @Valid @RequestBody Company company) {
        return service.saveCompany(company);
    }

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return service.getAllCompanies();
    }
}
