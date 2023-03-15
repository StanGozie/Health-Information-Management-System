package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.AppUtil;
import com.example.healthcaremanagementsystem.Dto.request.DiagnosisDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.exceptions.ResourceNotFoundException;
import com.example.healthcaremanagementsystem.exceptions.UserNotFoundException;
import com.example.healthcaremanagementsystem.model.Diagnosis;
import com.example.healthcaremanagementsystem.model.Patient;
import com.example.healthcaremanagementsystem.model.User;
import com.example.healthcaremanagementsystem.repositories.DiagnosisRepository;
import com.example.healthcaremanagementsystem.repositories.PatientRepository;
import com.example.healthcaremanagementsystem.repositories.UserRepository;
import com.example.healthcaremanagementsystem.services.DiagnosisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiagnosisServiceImplementation implements DiagnosisService {

    private final AppUtil appUtil;
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final DiagnosisRepository diagnosisRepository;


    @Override
    public ResponseEntity<ApiResponse> diagnoseAPatient(String uuid, DiagnosisDto diagnosisDto) {

        User user = appUtil.getLoggedInUser();
        if(!userRepository.existsByEmail(user.getEmail()))
            throw new UserNotFoundException("User not found exception");

        Optional<Patient> patient = patientRepository.findByUuid(uuid);
        if(patient.isEmpty())
            throw new ResourceNotFoundException("Patient Not Found Exception");

        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setPatientFirstName(patient.get().getFirstName());
        diagnosis.setPatientLastName(patient.get().getLastName());
        diagnosis.setUuid(uuid);
        diagnosis.setDiagnosis(diagnosisDto.getDiagnosis());
        diagnosis.setPrescription(diagnosisDto.getPrescription());
        diagnosis.setHospitalVisited(user.getHealthCareProviderName());
        diagnosis.setHealthCareProviderName(patient.get().getHealthCareProviderName());
        diagnosis.setPhysicianName("Dr. "+ user.getFirstName() + " " + " " + user.getLastName());
        diagnosisRepository.save(diagnosis);
        return ResponseEntity.ok(new ApiResponse("Success", "Patient Diagnosis has been saved", diagnosis));
    }

    @Override
    public Optional<Diagnosis> viewAllDiagnoses(String firstName, String lastName) {
        Optional<Diagnosis> allDiagnoses = diagnosisRepository.findByPatientFirstNameAndPatientLastName(firstName, lastName);
        if(allDiagnoses.isEmpty()) {
            throw new ResourceNotFoundException("Patient diagnoses record not found");
        }
        return allDiagnoses;
    }
}
