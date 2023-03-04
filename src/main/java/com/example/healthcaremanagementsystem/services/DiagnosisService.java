package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.request.DiagnosisDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface DiagnosisService {
    ResponseEntity<ApiResponse> diagnoseAPatient(DiagnosisDto diagnosisDto);

}
