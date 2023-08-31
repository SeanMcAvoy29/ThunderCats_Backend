package org.example.cli;

public class SalesEmployee extends Employee{
    private double commissionRate;

    public SalesEmployee(int employeeId, String name, double salary, String bankAccNum, String nationalInsuranceNum, double commissionRate) {
        super(employeeId, name, salary, bankAccNum, nationalInsuranceNum);
        setCommissionRate(commissionRate);
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
}
