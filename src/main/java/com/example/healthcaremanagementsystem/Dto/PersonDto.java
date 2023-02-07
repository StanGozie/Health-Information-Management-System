package com.example.healthcaremanagementsystem.Dto;

import com.example.healthcaremanagementsystem.enums.Gender;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class PersonDto {
    @NotBlank(message = "firstname must not be null")
    private String firstName;
    private String middleName;
    @NotBlank (message = "firstname must not be null")
    private String lastName;
    @NotBlank (message = "dob must not be null")
    private String dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotBlank (message = "provider name must not be null")
    private String healthCareProviderName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
