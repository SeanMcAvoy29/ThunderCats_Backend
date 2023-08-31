package org.example.core;

import org.example.cli.EmployeeRequest;

public class EmployeeValidator {

    public String isValidEmployee(EmployeeRequest employee){
        if(employee.getName().length() > 50){
            return "Name Greater than 50 Characters";
        }

        if(employee.getBankAccNum().length() != 8 ){
            return "Bank account number is invalid";
        }

        if(employee.getNationalInsuranceNum().length() != 9){
            return "Incorrect National Insurance Number";
        }

        return null;
    }
}
