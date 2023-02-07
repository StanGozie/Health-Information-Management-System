package com.example.healthcaremanagementsystem.model;

import com.example.healthcaremanagementsystem.enums.MaritalStatus;
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
@Getter
@Setter
public class Patient extends Person{

    private String uuid;
    private MaritalStatus maritalStatus;
    private String occupation;
    private String bloodGroup;
    private String genotype;

}
