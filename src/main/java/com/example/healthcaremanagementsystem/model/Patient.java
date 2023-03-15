package com.example.healthcaremanagementsystem.model;

import com.example.healthcaremanagementsystem.enums.MaritalStatus;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
@Getter
@Setter
@Table(name = "patient")
public class Patient extends Person {

    private String uuid;
    private String occupation;
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;
    private String healthCareProviderName;
    private String bloodGroup;
    private String genotype;
    private Boolean terminalIllness;
    private Boolean laboratoryVisit;
    private String laboratoryReport;
    private Boolean drugReactions;
    private String drugReactionDescription;

}