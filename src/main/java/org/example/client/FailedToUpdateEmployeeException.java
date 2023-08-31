package org.example.client;

public class FailedToUpdateEmployeeException extends Throwable{
    @Override
    public String getMessage(){
        return "Failed to Update Employee";
    }
}
