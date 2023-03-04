package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.request.PatientDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.model.Diagnosis;
import com.example.healthcaremanagementsystem.model.LabInvestigation;
import com.example.healthcaremanagementsystem.model.Patient;
import com.example.healthcaremanagementsystem.repositories.HealthCareProviderRepository;
import com.example.healthcaremanagementsystem.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api/v1/")
@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private HealthCareProviderRepository healthProviderRepository;



    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("add-patient")
    public ResponseEntity<ApiResponse> addPatient(@RequestBody PatientDto patientDto){
        return patientService.addPatient(patientDto);
    }

    @PatchMapping ("update-patient-data")
    public ResponseEntity<ApiResponse> updatePatientData(@RequestParam Long id, @RequestBody PatientDto patientDto){
        return patientService.updatePatientInfo(id, patientDto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("delete/id")
    public ResponseEntity<ApiResponse> deletePatient(@RequestBody Long id){
        return patientService.deletePatient(id);
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("view-patient")
    public Optional<Patient> viewPatient(@RequestParam Long id) {
        return patientService.viewPatient(id);
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("view-diagnosis")
    public Optional<Diagnosis> viewDiagnosis(@RequestParam Long id, @RequestParam String uuid) {
        return patientService.viewDiagnosis(id, uuid);
    }
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("/view-labTest")
    public Optional<LabInvestigation> viewLabInvestigation(@RequestParam Long id, @RequestParam String uuid){
        return patientService.viewLabInvestigation(id, uuid);
    }
}
