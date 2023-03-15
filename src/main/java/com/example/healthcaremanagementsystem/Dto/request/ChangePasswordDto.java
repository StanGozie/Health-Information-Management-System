package com.example.healthcaremanagementsystem.Dto.request;

import lombok.Data;

@Data
public class ChangePasswordDto {

    private String newPassword;
    private String confirmNewPassword;
}
