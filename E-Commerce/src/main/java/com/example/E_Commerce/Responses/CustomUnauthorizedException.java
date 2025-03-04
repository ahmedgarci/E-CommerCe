package com.example.E_Commerce.Responses;

public class CustomUnauthorizedException extends RuntimeException {
    public CustomUnauthorizedException(String msg){
        super(msg);
    }
    
}
