package com.example.healthcaremanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PatientHealthInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Patient patient;
    private Boolean terminalIllness;
    private String lastHospitalVisited;
    private Date lastDateOfHospitalVisit;
    private Boolean laboratoryVisit;
    private String laboratoryReport;
    private String diagnosis;
    private Boolean drugReactions;
    private String drugReactionDescription;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date UpdatedAt;
}
