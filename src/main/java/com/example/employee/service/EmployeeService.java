package com.example.employee.service;

import com.example.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    List<Employee> listAll();

    Employee findById(Integer id);

    Page<Employee> listByPage(Pageable pageable);

    List<Employee> listAllMale();

    void deleteById(Integer id);

    Employee save(Employee employee);

    int update(Employee employee);
}