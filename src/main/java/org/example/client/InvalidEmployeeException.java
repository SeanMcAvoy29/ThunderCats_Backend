package org.example.client;

public class InvalidEmployeeException extends Throwable{
    public InvalidEmployeeException(String error){
        super(error);
    }
}
