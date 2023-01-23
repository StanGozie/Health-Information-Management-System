package com.example.healthcaremanagementsystem.Dto;

import com.example.healthcaremanagementsystem.enums.MaritalStatus;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class PatientDto {

    @NotBlank (message = "firstname must not be null")
    private String firstName;

    private String middleName;

    @NotBlank (message = "firstname must not be null")
    private String lastName;

    @NotNull(message = "dob must not be null")
    private String dob;

    @NotBlank (message = "marital status must not be null")
    private MaritalStatus maritalStatus;

    @NotBlank (message = "occupation must not be null")
    private String occupation;

    @NotNull (message = "blood group must not be null")
    private char bloodGroup;

    @NotNull(message = "genotype must not be null")
    private char genotype;

    @ManyToOne
    @NotBlank (message = "firstname must not be null")
    private HealthCareProvider healthCareProvider;
}
