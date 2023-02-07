package com.example.healthcaremanagementsystem;

import org.springframework.stereotype.Service;

@Service
public class AppUtils {
    public boolean validEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}
