package com.example.employee.service.impl;

import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String MALE = "male";

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> listByPage(Pageable pageable) {
        return employeeRepository.findAllEmployees(pageable);
    }

    @Override
    public List<Employee> listAllMale() {
        return employeeRepository.listByGender(MALE);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee save(Employee employee) {

        Integer lastId = employeeRepository.findLastId();
        employee.setId(lastId + 1);

        return employeeRepository.save(employee);
    }

    @Override
    public int update(Employee employee) {

        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
        if (!employeeOptional.isPresent()) return -1;

        employeeRepository.save(employee);
        return 1;
    }
}