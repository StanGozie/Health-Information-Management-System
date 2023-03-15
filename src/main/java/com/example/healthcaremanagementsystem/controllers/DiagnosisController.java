package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.request.DiagnosisDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.model.Diagnosis;
import com.example.healthcaremanagementsystem.services.DiagnosisService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @PreAuthorize("hasRole('DOCTOR')")
    @PostMapping("diagnose-patient")
    public ResponseEntity<ApiResponse> diagnoseAPatient(@RequestParam String uuid, @RequestBody DiagnosisDto diagnosisDto) {
        return diagnosisService.diagnoseAPatient(uuid, diagnosisDto);
    }
    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("view-all-diagnosis")
    public Optional<Diagnosis> viewAllDiagnoses(@RequestParam String firstName, @RequestParam String lastName) {
        return diagnosisService.viewAllDiagnoses(firstName, lastName);
    }
}
