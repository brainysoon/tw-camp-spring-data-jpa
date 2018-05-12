package com.example.employee.controller;

import com.example.employee.constant.UriConstants;
import com.example.employee.domain.Response;
import com.example.employee.entity.Company;
import com.example.employee.entity.Employee;
import com.example.employee.enums.ResponseInfoEnum;
import com.example.employee.service.CompanyService;
import com.example.employee.service.EmployeeService;
import com.example.employee.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(UriConstants.COMPANIES)
    public Response<List<Company>> listAllCompanies() {

        return ResponseWrapper.wrapResponse(ResponseInfoEnum.REQUEST_SUCCESSFULLY, companyService.listAll());
    }

    @GetMapping(UriConstants.COMPANIES_ID)
    public Response<Company> findBy(@PathVariable Integer id) {

        Company company = companyService.findById(id);
        ResponseInfoEnum responseInfoEnum = company != null ?
                ResponseInfoEnum.REQUEST_SUCCESSFULLY : ResponseInfoEnum.RESOURCE_NOT_FOUND;
        return ResponseWrapper.wrapResponse(responseInfoEnum, company);
    }


    @GetMapping(UriConstants.COMPANIES_ID_EMPLOYEES)
    public Response<List<Employee>> listEmployeeByCompanyId(@PathVariable Integer id) {

        List<Employee> employees = employeeService.listByCompanyId(id);
        ResponseInfoEnum responseInfoEnum = employees.size() > 0 ?
                ResponseInfoEnum.REQUEST_SUCCESSFULLY : ResponseInfoEnum.RESOURCE_NOT_FOUND;
        return ResponseWrapper.wrapResponse(responseInfoEnum, employees);
    }

    @GetMapping(UriConstants.COMPANIES_PAGE_PAGENUM_PAGESIZE_PAGESIZENUM)
    public Response<Page<Company>> listByPage(@PathVariable Integer pageNum, @PathVariable Integer pagesizeNum) {
        Pageable pageable = PageRequest.of(pageNum, pagesizeNum);

        Page<Company> companyPage = companyService.listByPage(pageable);
        ResponseInfoEnum responseInfoEnum = companyPage.getSize() > 0 ?
                ResponseInfoEnum.REQUEST_SUCCESSFULLY : ResponseInfoEnum.RESOURCE_NOT_FOUND;
        return ResponseWrapper.wrapResponse(responseInfoEnum, companyPage);
    }
}