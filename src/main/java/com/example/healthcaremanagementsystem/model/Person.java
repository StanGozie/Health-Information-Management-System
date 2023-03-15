package com.example.healthcaremanagementsystem.model;

import com.example.healthcaremanagementsystem.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Person extends BaseClass{

    private String firstName;
    private String middleName;
    private String lastName;
    private String dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String phoneNumber;
}