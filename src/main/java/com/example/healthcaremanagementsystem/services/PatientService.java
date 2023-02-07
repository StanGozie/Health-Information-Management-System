package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.PatientDto;
import com.example.healthcaremanagementsystem.model.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface PatientService {
    ResponseEntity<String> addPatient(Long id, PatientDto patientDto);
    ResponseEntity<String> updatePatientInfo(Long id, PatientDto patientDto);
    ResponseEntity<String> deletePatient(String name, Long id);
    Optional<Patient> viewPatient(String name, Long id);
}
