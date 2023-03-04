package com.example.healthcaremanagementsystem.Dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LabInvestigationDto {

    @NotBlank (message = "Patient uuid cannot be blank")
    private String uuid;

    @NotBlank(message = "First name cannot be blank")
    private String patientFirstName;

    @NotBlank(message = "Last name cannot be blank")
    private String patientLastName;

    @NotBlank(message = "Investigation name cannot be blank")
    private String nameOfInvestigation;

    @NotBlank(message = "Sample name cannot be blank")
    private String samples;

    @NotBlank(message = "Result cannot be blank")
    private String result;

    @NotBlank(message = "Suspicion cannot be blank")
    private String suspicion;

    @NotBlank(message = "HealthcareProvider name cannot be blank")
    private String healthcareProviderName;

    @NotBlank(message = "Physician's name cannot be blank")
    private String physicianName;

    @NotBlank(message = "Lab investigator's name cannot be blank")
    private String investigatorName;
}
