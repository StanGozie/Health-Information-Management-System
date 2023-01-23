package com.example.healthcaremanagementsystem.Dto;

import com.example.healthcaremanagementsystem.enums.Category;
import com.example.healthcaremanagementsystem.enums.Level;
import com.example.healthcaremanagementsystem.enums.Specialty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class HealthCareProviderDto {

    @NotBlank(message = "name must not be blank")
    private String name;
    @NotBlank (message = "city must not be blank")
    private String city;
    @NotBlank (message = "state must not be null")
    private String State;
    @NotBlank (message = "email must not be null")
    private String email;
    @NotNull(message = "level must not be null")
    private Level level;
    private String website;
    @NotBlank (message = "director must not be null")
    private String director;
    @NotNull(message = "phone number must not be null")
    private Long phoneNumber;
    @NotNull (message = "category must not be null")
    private Category category;
    @NotBlank (message = "specialty must not be null")
    private Specialty specialty;
}
