package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.request.DiagnosisDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.model.Diagnosis;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface DiagnosisService {
    ResponseEntity<ApiResponse> diagnoseAPatient(String uuid, DiagnosisDto diagnosisDto);
    Optional<Diagnosis> viewAllDiagnoses(String firstName, String lastName);
}
