package org.example.client;

public class FailedToCreateDeliveryEmployee extends Throwable{
    @Override
    public String getMessage(){
        return "Failed to Create Delivery Employee";
    }
}
