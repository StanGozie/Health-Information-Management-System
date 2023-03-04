package com.example.healthcaremanagementsystem.exceptions;

public class MailSendingException extends RuntimeException {
    public MailSendingException(String errorMessage) {
            super(errorMessage);
    }
}
