package com.example.healthcaremanagementsystem.model;

import com.example.healthcaremanagementsystem.enums.Gender;
import com.example.healthcaremanagementsystem.enums.Role;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;
}
