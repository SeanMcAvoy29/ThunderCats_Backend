package org.example.client;

public class EmployeeDoesNotExistException extends Throwable {
    @Override
    public String getMessage(){
        return "Employee does not Exist";
    }
}
