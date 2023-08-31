package org.example.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployeeRequest extends EmployeeRequest {
    private double commissionRate;

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    @JsonCreator
    public SalesEmployeeRequest(@JsonProperty("name") String name,
                                @JsonProperty("salary") double salary,
                                @JsonProperty("bankAccountNumber") String bankAccNum,
                                @JsonProperty("nationalInsuranceNumber") String nationalInsuranceNum,
                                @JsonProperty("commissionRate") double commissionRate) {
        super(name, salary, bankAccNum, nationalInsuranceNum);
        this.commissionRate = commissionRate;
    }
}
