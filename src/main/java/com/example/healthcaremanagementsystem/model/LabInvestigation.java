package com.example.healthcaremanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LabInvestigation extends BaseClass{

    private String uuid;
    private String patientFirstName;
    private String patientLastName;
    private String nameOfInvestigation;
    private String samples;
    private String result;
    private String suspicion;
    private String healthcareProviderName;
    private String physicianName;
    private String investigatorName;
}
