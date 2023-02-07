package com.example.healthcaremanagementsystem.model;

import com.example.healthcaremanagementsystem.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import java.util.Collection;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User extends Person{

    private String email;
    private String password;
    private boolean enabled;
    private Role role;
    public User(String email, String password, Collection<? extends GrantedAuthority> grantedAuthorities) {
    }
}
