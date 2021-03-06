package com.example.employee.service;

import com.example.employee.entity.Company;
import com.example.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    List<Company> listAll();

    Company findById(Integer id);

    Page<Company> listByPage(Pageable pageable);

    Company save(Company company);

    int update(Integer id, String companyName, Integer employeesNumber);

    void deleteById(Integer id);

    List<Employee> listEmployeesByCompanyId(Integer id);
}