package org.example.client;

public class InvalidSalesEmployeeException extends Throwable {
    public InvalidSalesEmployeeException(String error) {
        super(error);
    }
}
