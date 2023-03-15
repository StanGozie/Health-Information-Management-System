package com.example.healthcaremanagementsystem.model;

import com.example.healthcaremanagementsystem.enums.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends Person {

    @Enumerated(EnumType.STRING)
    private Role role;
    private String email;
    private String password;
    private Boolean isActive;
    private String confirmationToken;
    private String healthCareProviderName;

}
