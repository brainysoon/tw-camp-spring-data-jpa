package com.example.employee.util;

import com.example.employee.domain.ValidationError;
import com.example.employee.entity.Company;
import com.example.employee.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtils {

    public static List<ValidationError> validateCompany(Company company) {
        List<ValidationError> validationErrors = new ArrayList<>();

        if (isEmpty(company.getCompanyName())) {
            ValidationError validationError = new ValidationError("companyName", "companyName can not be empty");
            validationErrors.add(validationError);
        }

        if (!greaterThanZero(company.getEmployeesNumber())) {
            ValidationError validationError = new ValidationError("employeesNumber", "employeesNumber must be greater than zero");
            validationErrors.add(validationError);
        }

        return validationErrors;
    }

    public static List<ValidationError> validateEmployee(Employee employee) {
        List<ValidationError> validationErrors = new ArrayList<>();

        if (isEmpty(employee.getName())) {
            ValidationError validationError = new ValidationError("name", "employee name must not be null");
            validationErrors.add(validationError);
        }

        if (isEmpty(employee.getGender())) {
            ValidationError validationError = new ValidationError("gender", "employee gender must not be null");
            validationErrors.add(validationError);
        }

        if (!greaterThanZero(employee.getAge())) {
            ValidationError validationError = new ValidationError("age", "employee age must greater than 0");
            validationErrors.add(validationError);
        }

        if (!greaterThanZero(employee.getSalary())){
            ValidationError validationError = new ValidationError("salary", "employee salary must greater than 0");
            validationErrors.add(validationError);
        }

        return validationErrors;
    }

    private static boolean isEmpty(String target) {

        return target == null || target.isEmpty();
    }

    private static boolean greaterThanZero(Integer target) {

        return target != null && target > 0;
    }
}
