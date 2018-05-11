package com.example.employee.service;

import com.example.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> listByCompanyId(Integer companyId);
}