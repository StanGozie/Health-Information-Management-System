package com.example.healthcaremanagementsystem.interfaces;

import com.example.healthcaremanagementsystem.Dto.HealthCareProviderDto;
import com.example.healthcaremanagementsystem.Dto.PatientDto;
import com.example.healthcaremanagementsystem.model.Patient;

import java.util.Optional;

public interface ProviderInterface {
    String addPatient(PatientDto patientDto);
    String updatePatientData(Long id, PatientDto patientDto);
    String deletePatient(Long id);
    Optional<Patient> viewPatient(Long id);
    String registerNewProvider(HealthCareProviderDto healthCareProviderDto);
    String updateProviderInformation(Long id);
    String viewProviderInformation(Long id);
    String deleteProviderInformation(Long id);
}
