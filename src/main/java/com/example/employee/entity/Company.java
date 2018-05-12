package com.example.employee.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String companyName;

    private Integer employeesNumber;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinColumn(name = "companyId")
    private List<Employee> employees;

    public Company() {
    }

    public Company(String companyName, Integer employeesNumber, Integer id) {
        this.id = id;
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}