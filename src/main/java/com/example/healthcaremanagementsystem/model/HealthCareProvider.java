package com.example.healthcaremanagementsystem.model;

import com.example.healthcaremanagementsystem.enums.Category;
import com.example.healthcaremanagementsystem.enums.Level;
import com.example.healthcaremanagementsystem.enums.Specialty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthCareProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String State;
    private String email;
    private Level level;
    private String website;
    private String director;
    private Long phoneNumber;
    private Category category;
    private Specialty specialty;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date UpdatedAt;
}
