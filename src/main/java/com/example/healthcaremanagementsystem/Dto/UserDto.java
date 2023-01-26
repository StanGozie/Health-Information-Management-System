package com.example.healthcaremanagementsystem.Dto;

import com.example.healthcaremanagementsystem.enums.Gender;
import com.example.healthcaremanagementsystem.enums.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotBlank(message = "name must not be blank")
    private String name;
    @NotBlank(message = "email must not be blank")
    private String email;
    @NotBlank(message = "password must not be blank")
    private String password;
    @NotNull(message = "role must not be null")
    private Role role;
    @NotNull(message = "Gender must not be null")
    private Gender gender;
}
