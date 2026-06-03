package com.placement.placement_management_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.placement.placement_management_system.entity.Company;
import com.placement.placement_management_system.repository.CompanyRepository;

@Service
public class CompanyService {

    private CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public Company saveCompany(Company company) {
        return repository.save(company);
    }

    public List<Company> getAllCompanies() {
        return repository.findAll();
    }
}
