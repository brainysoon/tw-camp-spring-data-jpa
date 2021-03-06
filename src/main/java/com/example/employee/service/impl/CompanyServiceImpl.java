package com.example.employee.service.impl;

import com.example.employee.entity.Company;
import com.example.employee.entity.Employee;
import com.example.employee.repository.CompanyRepository;
import com.example.employee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    @Override
    public Company save(Company company) {

        Integer lastId = companyRepository.findLastId();
        company.setId(lastId + 1);

        return companyRepository.save(company);
    }

    @Override
    public int update(Integer id, String companyName, Integer employeesNumber) {
        return companyRepository.updateById(id, companyName, employeesNumber);
    }

    @Override
    public void deleteById(Integer id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<Employee> listEmployeesByCompanyId(Integer id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        Company company = companyOptional.orElse(null);
        return company == null ? Collections.emptyList() : company.getEmployees();
    }
}
