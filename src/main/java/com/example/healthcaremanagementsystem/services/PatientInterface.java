package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.PatientDto;
import com.example.healthcaremanagementsystem.model.Patient;

import java.util.Optional;

public interface PatientInterface {
    public String addPatient(String email, String password, Long id, PatientDto patientDto);
    public String updatePatientInfo(String email, String password, Long id, PatientDto patientDto);
    String deletePatient(Long id);
    Optional<Patient> viewPatient(Long id);
}
