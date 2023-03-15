package com.example.healthcaremanagementsystem.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diagnosis extends BaseClass {

    private String uuid;
    private String patientFirstName;
    private String patientLastName;
    private String healthCareProviderName;
    private String physicianName;
    private String hospitalVisited;
    private String diagnosis;
    private String prescription;
}
