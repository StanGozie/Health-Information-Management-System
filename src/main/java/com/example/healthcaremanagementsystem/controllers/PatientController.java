package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.request.PatientDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.exceptions.UserNotFoundException;
import com.example.healthcaremanagementsystem.model.Diagnosis;
import com.example.healthcaremanagementsystem.model.LabInvestigation;
import com.example.healthcaremanagementsystem.model.Patient;
import com.example.healthcaremanagementsystem.repositories.HealthCareProviderRepository;
import com.example.healthcaremanagementsystem.services.PatientService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/api/v1/")
@RestController
public class PatientController {

    private final PatientService patientService;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("add-patient")
    public ResponseEntity<ApiResponse> addPatient(@RequestBody PatientDto patientDto){
        return patientService.addPatient(patientDto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping ("update-patient-data")
    public ResponseEntity<ApiResponse> updatePatientData(@RequestParam Long id, @RequestBody PatientDto patientDto){
        return patientService.updatePatientInfo(id, patientDto);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("delete/id")
    public ResponseEntity<ApiResponse> deletePatient(@RequestParam String uuid){
        return patientService.deletePatient(uuid);
    }

    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("view-patient")
    public Optional<Patient> viewPatient(@RequestParam String uuid) {
        return patientService.viewPatientByUuid(uuid);
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
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("/view-by-phoneNumber")
    public Optional<Patient> viewPatientByPhoneNumber (@RequestParam String phoneNumber) {
        return patientService.viewPatientByPhoneNumber(phoneNumber);
    }
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("/view-by-middle-and-last-names")
    public Optional<Patient> viewPatientByMiddleNameAndLastName (@RequestBody String middleName, @RequestBody String lastName) {
        return patientService.viewPatientByMiddleNameAndLastName(middleName, lastName);
    }
}
