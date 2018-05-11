package com.example.employee.service;

import com.example.employee.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {

    List<Company> listAll();

    Company findById(Integer id);

    Page<Company> listByPage(Pageable pageable);
}