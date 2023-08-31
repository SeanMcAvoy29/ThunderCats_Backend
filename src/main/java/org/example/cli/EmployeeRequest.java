package org.example.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequest {
    private String name;
    private double salary;
    private String bankAccNum;
    private String nationalInsuranceNum;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBankAccNum() {
        return bankAccNum;
    }

    public void setBankAccNum(String bankAccNum) {
        this.bankAccNum = bankAccNum;
    }

    public String getNationalInsuranceNum() {
        return nationalInsuranceNum;
    }

    public void setNationalInsuranceNum(String nationalInsuranceNum) {
        this.nationalInsuranceNum = nationalInsuranceNum;
    }

    @JsonCreator
    public EmployeeRequest(
            @JsonProperty("name") String name,
            @JsonProperty("salary") double salary,
            @JsonProperty("bankAccNum") String bankAccNum,
            @JsonProperty("nationalInsuranceNum") String nationalInsuranceNum)
    {
        this.name = name;
        this.salary = salary;
        this.bankAccNum = bankAccNum;
        this.nationalInsuranceNum = nationalInsuranceNum;
    }


}
