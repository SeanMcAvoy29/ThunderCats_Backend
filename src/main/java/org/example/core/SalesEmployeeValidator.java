package org.example.core;

import org.example.cli.SalesEmployeeRequest;

public class SalesEmployeeValidator {
    public String IsValidSalesEmployee(SalesEmployeeRequest salesEmployeeRequest) {

        if (salesEmployeeRequest.getCommissionRate() < 0 && salesEmployeeRequest.getCommissionRate() > 1 ){
            return "Commission rate not a percentage";
        }

        return null;
    }
}
