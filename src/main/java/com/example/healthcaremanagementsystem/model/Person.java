package com.example.healthcaremanagementsystem.model;

import com.example.healthcaremanagementsystem.enums.Gender;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String healthCareProviderName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
