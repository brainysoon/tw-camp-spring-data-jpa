package com.example.employee.controller;

import com.example.employee.constant.UriConstants;
import com.example.employee.domain.Response;
import com.example.employee.entity.Employee;
import com.example.employee.enums.ResponseInfoEnum;
import com.example.employee.service.EmployeeService;
import com.example.employee.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(UriConstants.EMPLOYEES)
    public Response<List<Employee>> listAll() {

        List<Employee> employees = employeeService.listAll();
        return ResponseWrapper.wrapGetResponse(List::isEmpty, employees);
    }

    @GetMapping(UriConstants.EMPLOYEES_ID)
    public Response<Employee> findById(@PathVariable Integer id) {

        Employee employee = employeeService.findById(id);
        return ResponseWrapper.wrapGetResponse(Objects::isNull, employee);
    }

    @GetMapping(UriConstants.EMPLOYEES_PAGE_NUM_PAGESIZE_NUM)
    public Response<Page<Employee>> listByPage(@PathVariable Integer pageNum, @PathVariable Integer pagesizeNum) {
        Pageable pageable = PageRequest.of(pageNum, pagesizeNum);

        Page<Employee> employeePage = employeeService.listByPage(pageable);
        return ResponseWrapper.wrapGetResponse(page -> !page.hasContent(), employeePage);
    }

    @GetMapping(UriConstants.EMPLOYEES_MALE)
    public Response<List<Employee>> listAllMale() {

        List<Employee> employees = employeeService.listAllMale();
        return ResponseWrapper.wrapGetResponse(List::isEmpty, employees);
    }

    @DeleteMapping(UriConstants.EMPLOYEES_ID)
    public Response<Object> deleteById(@PathVariable Integer id) {

        employeeService.deleteById(id);
        return ResponseWrapper.wrapResponse(ResponseInfoEnum.NO_CONTENT);
    }
}
