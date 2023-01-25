package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.PatientDto;
import com.example.healthcaremanagementsystem.model.Patient;
import com.example.healthcaremanagementsystem.serviceImplementation.PatientServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("api/v1/")
@RestController
public class PatientController {

    private final PatientServiceImplementation patientServiceImplementation;


    @PostMapping("add-patient")
    public String addPatient(@RequestBody String email, @RequestBody String password, @RequestBody Long id, @RequestBody PatientDto patientDto){
        return patientServiceImplementation.addPatient(email, password, id, patientDto);
    }

    @PutMapping("update-patient/{email}/{id}")
    public String updatePatientData(@RequestBody String email, @RequestBody String password, @PathVariable Long id, @RequestBody PatientDto patientDto){
        return patientServiceImplementation.updatePatientInfo(email, password, id, patientDto);
    }

    @DeleteMapping("delete/id")
    public String deletePatient(@PathVariable Long id){
        return patientServiceImplementation.deletePatient(id);
    }

    @GetMapping("view-patient")
    public Optional<Patient> viewPatient(@PathVariable Long id){
        return patientServiceImplementation.viewPatient(id);
    }
}
