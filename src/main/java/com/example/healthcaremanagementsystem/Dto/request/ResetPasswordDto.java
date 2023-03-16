package com.example.healthcaremanagementsystem.Dto.request;

import lombok.Data;

@Data
public class ResetPasswordDto {
    private String token;
    private String newPassword;
    private String confirmPassword;

}
