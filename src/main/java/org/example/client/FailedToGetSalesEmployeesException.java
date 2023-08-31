package org.example.client;

public class FailedToGetSalesEmployeesException extends Throwable {
    @Override
    public String getMessage() {
        return "Failed to get Sales Employees";
    }
}
