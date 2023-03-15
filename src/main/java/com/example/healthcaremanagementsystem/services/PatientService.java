package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.request.PatientDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.model.Diagnosis;
import com.example.healthcaremanagementsystem.model.LabInvestigation;
import com.example.healthcaremanagementsystem.model.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface PatientService {
    ResponseEntity<ApiResponse> addPatient(PatientDto patientDto);
    ResponseEntity<ApiResponse> updatePatientInfo(Long id, PatientDto patientDto);
    ResponseEntity<ApiResponse> deletePatient(String uuid);
    Optional<Patient> viewPatientByUuid (String uuid);
    Optional<Patient> viewPatientByMiddleNameAndLastName (String middleName, String lastName);
    Optional<Patient> viewPatientByPhoneNumber (String phoneNumber);
    Optional<Diagnosis> viewDiagnosis(Long id, String uuid);
    Optional<LabInvestigation> viewLabInvestigation (Long id, String uuid);
}
