package com.example.healthcaremanagementsystem.Dto.request;

import com.example.healthcaremanagementsystem.enums.Category;
import com.example.healthcaremanagementsystem.enums.Level;
import com.example.healthcaremanagementsystem.enums.Specialty;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data

public class HealthCareProviderDto {

    @NotBlank(message = "name must not be blank")
    private String name;

    @NotBlank (message = "city must not be blank")
    private String city;

    @NotBlank (message = "state must not be null")
    private String State;

    @NotBlank(message = "email must not be null")
    private String email;

    @NotNull(message = "level must not be null")
    @Enumerated(EnumType.STRING)
    private Level level;

    private String website;

    @NotBlank (message = "director must not be null")
    private String director;

    @NotNull(message = "phone number must not be null")
    private String phoneNumber;

    @NotNull (message = "category must not be null")
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotBlank (message = "specialty must not be null")
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
}
