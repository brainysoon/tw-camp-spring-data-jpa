package com.example.employee.controller;

import com.example.employee.constant.UriConstants;
import com.example.employee.domain.Response;
import com.example.employee.entity.Company;
import com.example.employee.enums.ResponseInfoEnum;
import com.example.employee.service.CompanyService;
import com.example.employee.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping(UriConstants.COMPANIES)
    public Response<List<Company>> listAllCompanies() {

        return ResponseWrapper.wrapResult(ResponseInfoEnum.REQUEST_SUCCESSFULLY, companyService.listAll());
    }

    @GetMapping(UriConstants.COMPANIES_ID)
    public Response<Company> findBy(@PathVariable Integer id) {

        Company company = companyService.findById(id);
        ResponseInfoEnum responseInfoEnum = company != null ?
                ResponseInfoEnum.REQUEST_SUCCESSFULLY : ResponseInfoEnum.RESOURCE_NOT_FOUND;
        return ResponseWrapper.wrapResult(responseInfoEnum, company);
    }
}
