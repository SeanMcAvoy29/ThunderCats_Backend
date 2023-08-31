package org.example.client;

public class FailedToCreateSalesEmployeeException extends Throwable {
    @Override
    public String getMessage() {
        return "Failed to create a Sales Employee";
    }
}
