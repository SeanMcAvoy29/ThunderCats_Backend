package org.example.core;

import org.example.cli.EmployeeRequest;
import org.example.cli.SalesEmployeeRequest;

public class SalesEmployeeValidator {

    private EmployeeValidator employeeValidator = new EmployeeValidator();
    public String isValidSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) {

        EmployeeRequest employeeRequest = new EmployeeRequest(salesEmployeeRequest.getName(),
                salesEmployeeRequest.getSalary(),
                salesEmployeeRequest.getBankAccNum(),
                salesEmployeeRequest.getNationalInsuranceNum());

        String validatedEmployee = employeeValidator.isValidEmployee(employeeRequest);

        if (validatedEmployee != null) {
            return validatedEmployee;
        }

        if (salesEmployeeRequest.getCommissionRate() < 0 || salesEmployeeRequest.getCommissionRate() > 0.99 ){
            return "Commission rate not a percentage";
        }

        return null;
    }
}
