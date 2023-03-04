package com.example.healthcaremanagementsystem.Dto.request;

import com.example.healthcaremanagementsystem.enums.Gender;
import com.example.healthcaremanagementsystem.enums.MaritalStatus;
import com.example.healthcaremanagementsystem.enums.Role;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Data
public class CompleteRegistrationDto {

    @NotBlank(message = "dob must not be null")
    private String dob;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
}
