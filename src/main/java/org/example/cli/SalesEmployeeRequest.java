package org.example.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployeeRequest {
    private EmployeeRequest employeeRequest;
    private double commissionRate;

    public EmployeeRequest getEmployeeRequest() {
        return employeeRequest;
    }

    public void setEmployeeRequest(EmployeeRequest employeeRequest) {
        this.employeeRequest = employeeRequest;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @JsonCreator
    public SalesEmployeeRequest(@JsonProperty("employeeRequest")EmployeeRequest employeeRequest,
                                @JsonProperty("commissionRate") double commissionRate) {
        this.employeeRequest = employeeRequest;
        this.commissionRate = commissionRate;
    }
}
