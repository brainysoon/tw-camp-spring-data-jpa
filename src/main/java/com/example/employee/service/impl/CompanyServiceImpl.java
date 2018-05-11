package com.example.employee.service.impl;

import com.example.employee.entity.Company;
import com.example.employee.repository.CompanyRepository;
import com.example.employee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> listAll() {
        return companyRepository.findAll();
    }
}
