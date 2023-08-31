package org.example.core;

import org.example.cli.SalesEmployeeRequest;

public class SalesEmployeeValidator {

    private EmployeeValidator employeeValidator = new EmployeeValidator();
    public String isValidSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) {

        String validatedEmployee = employeeValidator.isValidEmployee(salesEmployeeRequest.getEmployeeRequest());

        if (validatedEmployee != null) {
            return validatedEmployee;
        }

        if (salesEmployeeRequest.getCommissionRate() < 0 || salesEmployeeRequest.getCommissionRate() > 0.99 ){
            return "Commission rate not a percentage";
        }

        return null;
    }
}
