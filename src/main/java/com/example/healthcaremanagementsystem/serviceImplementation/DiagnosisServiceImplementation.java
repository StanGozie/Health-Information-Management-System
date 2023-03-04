package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.AppUtil;
import com.example.healthcaremanagementsystem.Dto.request.DiagnosisDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.exceptions.ResourceNotFoundException;
import com.example.healthcaremanagementsystem.exceptions.UserNotFoundException;
import com.example.healthcaremanagementsystem.model.Diagnosis;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import com.example.healthcaremanagementsystem.model.Patient;
import com.example.healthcaremanagementsystem.model.User;
import com.example.healthcaremanagementsystem.repositories.DiagnosisRepository;
import com.example.healthcaremanagementsystem.repositories.HealthCareProviderRepository;
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

    private final Patient patient;
    private final PatientRepository patientRepository;
    private final HealthCareProviderRepository healthCareProviderRepository;
    private final DiagnosisRepository diagnosisRepository;


    @Override
    public ResponseEntity<ApiResponse> diagnoseAPatient(DiagnosisDto diagnosisDto) {

        User user = appUtil.getLoggedInUser();
        if(! userRepository.existsByEmail(user.getEmail()) && userRepository.existsByHealthCareProviderName(diagnosisDto.getHealthcareProviderName()))
            throw new UserNotFoundException("User not found exception");

        Optional<Patient> patient = patientRepository.findByUuid(diagnosisDto.getUuid());
        if(patient.isEmpty())
            throw new ResourceNotFoundException("Patient Not Found Exception");

        Optional<HealthCareProvider> healthCareProvider = healthCareProviderRepository.findByName(diagnosisDto.getHealthcareProviderName());
        if(healthCareProvider.isEmpty())
            throw new ResourceNotFoundException("HealthCare Provider Not Found");

        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setUuid(diagnosisDto.getUuid());
        diagnosis.setPatientFirstName(diagnosisDto.getFirstName());
        diagnosis.setPatientLastName(diagnosisDto.getLastName());
        diagnosis.setHealthcareProviderName(diagnosis.getHealthcareProviderName());
        diagnosis.setDiagnosis(diagnosisDto.getDiagnosis());
        diagnosis.setPrescription(diagnosisDto.getPrescription());
        diagnosis.setPhysicianName("Dr. "+ user.getFirstName() + " " + user.getLastName());
        diagnosisRepository.save(diagnosis);
        return ResponseEntity.ok(new ApiResponse("Success", "Patient Diagnosis has been saved", diagnosis));
    }
}
