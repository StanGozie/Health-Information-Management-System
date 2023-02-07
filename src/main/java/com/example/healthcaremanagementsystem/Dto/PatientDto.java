package com.example.healthcaremanagementsystem.Dto;

import com.example.healthcaremanagementsystem.enums.MaritalStatus;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;

import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data

public class PatientDto extends PersonDto {


    @NotBlank (message = "marital status must not be null")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @NotBlank (message = "occupation must not be null")
    private String occupation;

    @NotNull (message = "blood group must not be null")
    private String bloodGroup;

    @NotNull(message = "genotype must not be null")
    private String genotype;

    @NotBlank (message = "firstname must not be null")
    private String healthCareProviderName;
}
