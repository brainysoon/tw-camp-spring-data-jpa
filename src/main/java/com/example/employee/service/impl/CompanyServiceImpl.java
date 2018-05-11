package com.example.employee.service.impl;

import com.example.employee.entity.Company;
import com.example.employee.repository.CompanyRepository;
import com.example.employee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> listAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(Integer id) {

        Optional<Company> companyOptional = companyRepository.findById(id);
        return companyOptional.orElse(null);
    }

    @Override
    public Page<Company> listByPage(Pageable pageable) {
        return companyRepository.findByPage(pageable);
    }
}
