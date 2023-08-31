package org.example.cli;

public class Employee {
    private int employeeId;
    private String name;
    private double salary;
    private String bankAccNum;
    private String nationalInsuranceNum;

    public Employee(int employeeId, String name, double salary, String bankAccNum, String nationalInsuranceNum) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.bankAccNum = bankAccNum;
        this.nationalInsuranceNum = nationalInsuranceNum;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

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
}
