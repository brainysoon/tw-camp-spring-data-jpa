package com.example.employee.util;

import com.example.employee.domain.ValidationError;
import com.example.employee.entity.Company;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtils {

    public static List<ValidationError> validateCompany(Company company) {
        List<ValidationError> validationErrors = new ArrayList<>();

        if (isEmpty(company.getCompanyName())) {
            ValidationError validationError = new ValidationError();
            validationError.setField("companyName");
            validationError.setError("companyName can not be empty");
            validationErrors.add(validationError);
        }

        if (!greaterThanZero(company.getEmployeesNumber())) {
            ValidationError validationError = new ValidationError();
            validationError.setField("employeesNumber");
            validationError.setError("employeesNumber must be greater than zero");
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
