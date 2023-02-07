package com.example.healthcaremanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PatientHealthInformation extends Patient {


    private Boolean terminalIllness;
    private String lastHospitalVisited;
    private LocalDateTime lastDateOfHospitalVisit;
    private Boolean laboratoryVisit;
    private String laboratoryReport;
    private String diagnosis;
    private Boolean drugReactions;
    private String drugReactionDescription;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime UpdatedAt;
}
