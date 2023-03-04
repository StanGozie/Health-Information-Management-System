package com.example.healthcaremanagementsystem.userUtils;

import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserUtils {

    public String getAuthenticatedUserEmail(){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loggedEmail = userDetails.getUsername();
        System.out.println(loggedEmail);
        return userDetails.getUsername();
    }
}
