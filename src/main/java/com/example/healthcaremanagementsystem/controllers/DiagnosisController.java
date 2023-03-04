package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.request.DiagnosisDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.services.DiagnosisService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @PreAuthorize("hasRole('DOCTOR')")
    @PostMapping("diagnose-patient")
    public ResponseEntity<ApiResponse> diagnoseAPatient(@RequestBody DiagnosisDto diagnosisDto) {
        return diagnosisService.diagnoseAPatient(diagnosisDto);
    }
}
