package com.example.healthcaremanagementsystem.exceptions;

public class HealthProviderNotFoundException extends RuntimeException{
    public  HealthProviderNotFoundException (String message) {
        super (message);
    }
}
