package com.example.employee.constant;

import com.example.employee.domain.Link;
import com.example.employee.util.LinkUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface UriConstants {

    String COMPANIES = "companies";
    String COMPANIES_ID = "companies/{id}";
    String COMPANIES_ID_EMPLOYEES = "companies/{id}/employees";
    String COMPANIES_PAGE_NUM_PAGESIZE_NUM = "companies/page/{pageNum}/pagesize/{pagesizeNum}";

    String EMPLOYEES = "employees";
    String EMPLOYEES_ID = "employees/{id}";
    String EMPLOYEES_PAGE_NUM_PAGESIZE_NUM = "employees/page/{pageNum}/pagesize/{pagesizeNum}";
    String EMPLOYEES_MALE = "employees/male";

    String HOME = "/";

    default List<Link> listLinks() throws Exception {
        return Arrays.stream(UriConstants.class.getFields())
                .map(LinkUtils::generateLink)
                .collect(Collectors.toList());
    }
}