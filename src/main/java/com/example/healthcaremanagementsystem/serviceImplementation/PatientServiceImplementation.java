package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.Dto.request.PatientDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.exceptions.ResourceNotFoundException;
import com.example.healthcaremanagementsystem.model.Diagnosis;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import com.example.healthcaremanagementsystem.model.LabInvestigation;
import com.example.healthcaremanagementsystem.repositories.DiagnosisRepository;
import com.example.healthcaremanagementsystem.repositories.HealthCareProviderRepository;
import com.example.healthcaremanagementsystem.model.Patient;
import com.example.healthcaremanagementsystem.repositories.LabInvestigationRepository;
import com.example.healthcaremanagementsystem.repositories.PatientRepository;
import com.example.healthcaremanagementsystem.services.PatientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
//@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@Service
public class PatientServiceImplementation implements PatientService {

    //@Autowired
    private final PatientRepository patientRepository;
    private final DiagnosisRepository diagnosisRepository;
    //@Autowired
    private final HealthCareProviderRepository healthProviderRepository;
    private final LabInvestigationRepository labInvestigationRepository;

    @Override
    public ResponseEntity<ApiResponse> addPatient(PatientDto patientDto) {

            Patient patient = new Patient();
            Optional<HealthCareProvider> healthCareProvider = healthProviderRepository.findByName(patientDto.getHealthcareProviderName());
            if(healthCareProvider.isEmpty())
                throw new ResourceNotFoundException("Healthcare Provider Information is Wrong.");
            BeanUtils.copyProperties(patientDto, patient);
            patientRepository.save(patient);

            return ResponseEntity.ok(new ApiResponse<>("Success","Patient information has been saved",null));
        }

    @Override
    public ResponseEntity<ApiResponse> updatePatientInfo(Long id, PatientDto patientDto) throws ResourceNotFoundException{

        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isEmpty())
            throw new ResourceNotFoundException("There is no patient with this Id.");

        Patient patient1 = new Patient();
        BeanUtils.copyProperties(patientDto, patient);

        return ResponseEntity.ok(new ApiResponse<>("Success", "Patient " + patient1.getFirstName() + "data has been updated.", null));

    }

    @Override
    public ResponseEntity<ApiResponse> deletePatient(Long id) {


       Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isEmpty()) {
            throw new ResourceNotFoundException("There is no patient with this Id.");
        }
        patientRepository.delete(patient.get());

        return ResponseEntity.ok(new ApiResponse<>("Success", "Patient data has been deleted",null));
    }

    @Override
    public Optional<Patient> viewPatient(Long id) {

            Optional<Patient> patient = patientRepository.findById(id);
            return patient;
    }

    @Override
    public Optional<Diagnosis> viewDiagnosis(Long id, String uuid) {
        Optional<Diagnosis> patientDiagnosis = diagnosisRepository.findByIdAndUuid(id, uuid);
        if(patientDiagnosis.isEmpty())
            throw new ResourceNotFoundException("Patient diagnosis not found");
        return patientDiagnosis;
    }

    @Override
    public Optional<LabInvestigation> viewLabInvestigation(Long id, String uuid) {
        Optional<LabInvestigation> labtest = labInvestigationRepository.findByIdAndUuid(id, uuid);
        if(labtest.isEmpty())
            throw new ResourceNotFoundException("Lab test not found");
        return labtest;
    }
}
