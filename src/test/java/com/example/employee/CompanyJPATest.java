package com.example.employee;


import com.example.employee.entity.Company;
import com.example.employee.repository.CompanyRepository;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class CompanyJPATest {
    @Autowired
    private CompanyRepository companyRepository;

    @Before
    public void setUp() throws Exception {
        //本地启动mysql，创建employee_db数据库
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:mysql://localhost:3306/employee_db", "root", "root");
        flyway.clean();
        flyway.migrate();
    }


    @Test
    public void should_return_company_employees_when_get_the_company() throws Exception {

        Optional<Company> companyOption = companyRepository.findById(0);
        Integer actualEmployeesNumber = 0;
        if (companyOption.isPresent()) actualEmployeesNumber = companyOption.get().getEmployees().size();

        assertThat(actualEmployeesNumber).isEqualTo(2);
    }

    @Test
    public void should_return_page_of_companies_when_get_the_companies_by_pageable() throws Exception {
        Pageable pageable = PageRequest.of(0, 2);

        Page<Company> companyPage = companyRepository.findByPage(pageable);

        assertThat(companyPage.getTotalPages()).isEqualTo(2);
    }

    @Test
    public void should_update_company_info_when_given_the_id_and_info() {
        Integer influenceLine = 1;

        Integer actualLine = companyRepository.updateById(0, "baba", 10);

        assertThat(actualLine).isEqualTo(influenceLine);
    }
}
