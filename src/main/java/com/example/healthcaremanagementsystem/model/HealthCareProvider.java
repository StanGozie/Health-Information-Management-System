package com.example.healthcaremanagementsystem.model;

import com.example.healthcaremanagementsystem.enums.Category;
import com.example.healthcaremanagementsystem.enums.Level;
import com.example.healthcaremanagementsystem.enums.Specialty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@Entity
@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor

public class HealthCareProvider extends BaseClass {

    private String name;
    private String city;
    private String State;
    private String email;
    @Enumerated(EnumType.STRING)
    private Level level;
    private String website;
    private String director;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;

}