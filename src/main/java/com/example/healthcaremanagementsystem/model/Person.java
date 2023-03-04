package com.example.healthcaremanagementsystem.model;

import com.example.healthcaremanagementsystem.enums.Gender;
import lombok.*;
import javax.persistence.*;

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


}