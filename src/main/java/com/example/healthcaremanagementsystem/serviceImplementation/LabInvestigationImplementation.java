package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.AppUtil;
import com.example.healthcaremanagementsystem.Dto.request.LabInvestigationDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.exceptions.ResourceNotFoundException;
import com.example.healthcaremanagementsystem.model.LabInvestigation;
import com.example.healthcaremanagementsystem.model.Patient;
import com.example.healthcaremanagementsystem.model.User;
import com.example.healthcaremanagementsystem.repositories.LabInvestigationRepository;
import com.example.healthcaremanagementsystem.repositories.PatientRepository;
import com.example.healthcaremanagementsystem.repositories.UserRepository;
import com.example.healthcaremanagementsystem.services.LabInvestigationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LabInvestigationImplementation implements LabInvestigationService {

    private final AppUtil appUtil;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final LabInvestigationRepository labInvestigationRepository;

    @Override
    public ResponseEntity<ApiResponse> labTest(LabInvestigationDto labInvestigationDto) {

        User user = appUtil.getLoggedInUser();

        userRepository.findByEmail(user.getEmail());

        Optional<Patient> patient = patientRepository.findByUuid(labInvestigationDto.getUuid());

        if (patient.isEmpty())
            throw new ResourceNotFoundException("Patient not found");

        LabInvestigation Investigation = new LabInvestigation();

        Investigation.setUuid(labInvestigationDto.getUuid());
        Investigation.setPatientFirstName(labInvestigationDto.getPatientFirstName());
        Investigation.setPatientLastName(labInvestigationDto.getPatientLastName());
        Investigation.setNameOfInvestigation(labInvestigationDto.getNameOfInvestigation());
        Investigation.setInvestigatorName(labInvestigationDto.getInvestigatorName());
        Investigation.setSamples(labInvestigationDto.getSamples());
        Investigation.setResult(labInvestigationDto.getResult());
        Investigation.setSuspicion(labInvestigationDto.getSuspicion());
        Investigation.setHealthcareProviderName(labInvestigationDto.getHealthcareProviderName());
        Investigation.setPhysicianName(labInvestigationDto.getPhysicianName());
        Investigation.setInvestigatorName(labInvestigationDto.getInvestigatorName());
        labInvestigationRepository.save(Investigation);

        return ResponseEntity.ok(new ApiResponse("Success", "Lab Investigation Recorded", Investigation));
    }
}
