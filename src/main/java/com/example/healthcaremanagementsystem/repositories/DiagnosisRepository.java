package com.example.healthcaremanagementsystem.repositories;

import com.example.healthcaremanagementsystem.model.Diagnosis;
import com.example.healthcaremanagementsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
    Optional<Diagnosis> findByIdAndUuid (Long id, String uuid);

//    Optional<Diagnosis>  findByIdAndUuid (Long id, String uuid);

    Optional<Diagnosis> findByPatientFirstNameAndPatientLastName (String firstName, String lastName);
    void deleteById(Long id);
}
