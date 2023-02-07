package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.Dto.PatientDto;
import com.example.healthcaremanagementsystem.repositories.ProviderRepository;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import com.example.healthcaremanagementsystem.model.Patient;
import com.example.healthcaremanagementsystem.repositories.PatientRepository;
import com.example.healthcaremanagementsystem.services.PatientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@AllArgsConstructor
@NoArgsConstructor
@Service
public class PatientServiceImplementation implements PatientService {

    private PatientRepository patientRepository;
    private ProviderRepository healthProviderRepository;


    @Override
    public ResponseEntity<String> addPatient(Long id, PatientDto patientDto) {

        Optional<HealthCareProvider> provider = healthProviderRepository.findById(id);
        if (provider.isPresent()) {
            Patient patient = new Patient();
            BeanUtils.copyProperties(patientDto, patient);
            patientRepository.save(patient);

            return ResponseEntity.ok("Patient information has been saved successfully");
        }
        return ResponseEntity.status(400).body("Healthcare Provider Information is Wrong.");
    }

    @Override
    public ResponseEntity<String> updatePatientInfo(Long id, PatientDto patientDto){

        Optional<HealthCareProvider> provider = healthProviderRepository.findById(id);
        if (provider.isEmpty()) {
            return ResponseEntity.status(400).body("Healthcare Provider does not exist");
        }
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isEmpty()) {
            Patient patient1 = new Patient();
            //BeanUtils.copyProperties(patientDto, patient1);
            BeanUtils.copyProperties(patientDto, patient);
            return ResponseEntity.ok("Patient " + patient1.getFirstName() + " has been updated.");
        }
        return ResponseEntity.status(404).body("There is no patient with this Id.");
    }

    @Override
    public ResponseEntity<String> deletePatient(String name, Long id) {

        Optional<HealthCareProvider> provider = healthProviderRepository.findByName(name);
        if (provider.isEmpty()) {
            return ResponseEntity.status(404).body("Healthcare Provider does not exist");
        }
       Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isEmpty()) {
            return ResponseEntity.status(404).body("There is no patient with this Id.");
        }
        patientRepository.delete(patient.get());

        return ResponseEntity.ok("Patient details has been deleted");
    }

    @Override
    public Optional<Patient> viewPatient(String name, Long id) {

        Optional<HealthCareProvider> provider = healthProviderRepository.findByName(name);
        if (provider.isPresent()) {

            Optional<Patient> patient = patientRepository.findById(id);
            if (patient.isPresent()) {
                patientRepository.findById(id).get();
                return patient;
            }
        }
        return Optional.empty();
    }
}


// A doctor user or a hospital IT admin user can update patient data. The doctor can do it at the point of diagnosis. The admin user can
// do it as the need arises.
//A doctor user also has the right to view a patient's health information.
// Only the admin user can delete a patient from the database.