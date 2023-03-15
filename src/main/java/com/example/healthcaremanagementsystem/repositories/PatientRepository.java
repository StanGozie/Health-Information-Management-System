package com.example.healthcaremanagementsystem.repositories;

import com.example.healthcaremanagementsystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByUuid (String uuid);
    Optional<Patient> findById (Long id);
    Optional<Patient> findByPhoneNumber (String phoneNumber);
    Optional<Patient> findByMiddleNameAndLastName(String middleName, String lastName);


}
