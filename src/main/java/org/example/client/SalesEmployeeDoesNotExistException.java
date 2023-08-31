package org.example.client;

public class SalesEmployeeDoesNotExistException extends Throwable {
    @Override
    public String getMessage() {
        return "Failed to get Sales Employee by Id";
    }
}
