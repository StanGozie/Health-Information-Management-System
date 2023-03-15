package com.example.healthcaremanagementsystem.Dto.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DiagnosisDto {


    @NotBlank(message = "Diagnosis cannot be blank")
    private String diagnosis;
    @NotBlank(message = "Prescription cannot be blank")
    private String prescription;

}
