package com.example.healthcaremanagementsystem.model;

import com.example.healthcaremanagementsystem.enums.Gender;
import com.example.healthcaremanagementsystem.enums.Role;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Gender gender;
    private Role role;
    private String password;
}
