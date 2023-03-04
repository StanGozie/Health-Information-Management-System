package com.example.healthcaremanagementsystem.Dto.request;

import com.example.healthcaremanagementsystem.enums.Gender;
import com.example.healthcaremanagementsystem.enums.MaritalStatus;
import lombok.Data;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PatientDto {

    @NotBlank(message = "uuid cannot be blank")
    private String uuid;

    @NotBlank(message = "firstname cannot be null")
    private String firstName;

    private String middleName;

    @NotBlank (message = "lastname cannot be null")
    private String lastName;

    @NotBlank (message = "dob cannot be null")
    private String dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotBlank(message = "Phone Number cannot be blank")
    private String phoneNumber;

    @NotBlank (message = "provider name cannot be null")
    private String healthcareProviderName;

    @NotNull (message = "marital status cannot be null")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @NotBlank (message = "occupation cannot be null")
    private String occupation;

    @NotNull (message = "blood group cannot be null")
    private String bloodGroup;

    @NotNull(message = "genotype cannot be null")
    private String genotype;

    @NotNull
    private boolean terminalIllness;

    @NotNull (message = "genotype cannot be null")
    private boolean laboratoryVisit;

    @NotNull
    private boolean drugReactions;

    private String drugReactionDescription;

    @NotBlank (message = "hospital name cannot be null")
    private String lastHospitalVisited;

    @NotBlank (message = "name cannot be null")
    private String physicianName;

}
