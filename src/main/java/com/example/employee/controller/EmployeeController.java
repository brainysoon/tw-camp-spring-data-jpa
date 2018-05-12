package com.example.employee.controller;

import com.example.employee.constant.UriConstants;
import com.example.employee.domain.Response;
import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;
import com.example.employee.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(UriConstants.EMPLOYEES)
    public Response<List<Employee>> listAll() {

        List<Employee> employees = employeeService.listAll();
        return ResponseWrapper.wrapGetResponse(List::isEmpty, employees);
    }
}
