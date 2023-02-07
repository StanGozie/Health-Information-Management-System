package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.PatientDto;
import com.example.healthcaremanagementsystem.model.Patient;
import com.example.healthcaremanagementsystem.serviceImplementation.PatientServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api/v1/")
@RestController
public class PatientController {

    private final PatientServiceImplementation patientServiceImplementation;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("add-patient")
    public ResponseEntity<String> addPatient(Long id, PatientDto patientDto){
        return patientServiceImplementation.addPatient(id, patientDto);
    }

    @PutMapping("update-patient")
    public ResponseEntity<String> updatePatientData(@RequestParam Long id, @RequestBody PatientDto patientDto){
        return patientServiceImplementation.updatePatientInfo(id, patientDto);
    }

    @DeleteMapping("delete/id")
    public ResponseEntity<String> deletePatient(@RequestBody String name, @RequestBody Long id){
        return patientServiceImplementation.deletePatient(name, id);
    }
    @PreAuthorize("hasRole('DOCTOR')")
    @GetMapping("view-patient")
    public Optional<Patient> viewPatient(@RequestBody String name, @RequestBody Long id) {
        return patientServiceImplementation.viewPatient(name, id);
    }
}
