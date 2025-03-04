package com.example.E_Commerce.Exceptions;

public class CustomEntityAlreadyExists extends RuntimeException {
    
    public CustomEntityAlreadyExists(String msg ){
        super(msg);
    }
}
