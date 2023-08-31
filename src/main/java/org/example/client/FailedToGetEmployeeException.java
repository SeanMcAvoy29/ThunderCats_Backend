package org.example.client;

public class FailedToGetEmployeeException extends Throwable{
    @Override
    public String getMessage(){
        return "Failed to Get Delivery Employee";
    }
}
