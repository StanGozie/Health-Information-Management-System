package com.example.healthcaremanagementsystem.Dto.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DiagnosisDto {

    @NotNull(message = "uuid cannot be null")
    private String uuid;
    @NotBlank(message = "First name cannot be blank")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;
    @NotNull(message = "provider Id cannot be null")
    private String healthcareProviderName;
    @NotBlank(message = "Physician's name cannot be blank")
    private String physicianName;
    @NotBlank(message = "Diagnosis cannot be blank")
    private String diagnosis;
    @NotBlank(message = "Prescription cannot be blank")
    private String prescription;

}
