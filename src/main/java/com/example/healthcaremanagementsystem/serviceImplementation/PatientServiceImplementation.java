package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.Dto.PatientDto;
import com.example.healthcaremanagementsystem.exceptions.EmailNotFoundException;
import com.example.healthcaremanagementsystem.exceptions.PasswordNotFoundException;
import com.example.healthcaremanagementsystem.exceptions.PatientNotFoundException;
import com.example.healthcaremanagementsystem.model.User;
import com.example.healthcaremanagementsystem.repositories.HealthProviderRepository;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import com.example.healthcaremanagementsystem.model.Patient;
import com.example.healthcaremanagementsystem.repositories.PatientRepository;
import com.example.healthcaremanagementsystem.interfaces.PatientInterface;
import com.example.healthcaremanagementsystem.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
@AllArgsConstructor
@NoArgsConstructor
@Service
public class PatientServiceImplementation implements PatientInterface {

    private PatientRepository patientRepository;
    private HealthProviderRepository healthProviderRepository;
    private UserRepository userRepository;


    @Override
    public String addPatient(String email, String password, Long id, PatientDto patientDto) {
        User user = userRepository.findByEmailAndPassword(email, password);
        Optional<HealthCareProvider> provider = healthProviderRepository.findById(id);
        if (provider.isPresent()) {
            Patient patient = new Patient();
            BeanUtils.copyProperties(patientDto, patient);
            patientRepository.save(patient);

            return "Patient information has been saved successfully";
        }
        return "You are not allowed to perform this operation";
    }

    @Override
    public String updatePatientInfo(String email, String password, Long id, PatientDto patientDto) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmailAndPassword(email, password));
        if (email.isEmpty()) {
            throw new EmailNotFoundException("Email not registered!");
        }
        if (password.isEmpty()) {
            throw new PasswordNotFoundException("Password wrong or Incorrect");
        }
        Optional<HealthCareProvider> provider = healthProviderRepository.findById(id);
        if (provider.isEmpty()) {
            throw new RuntimeException("You are not allowed to perform this operation");
        }
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isEmpty()) {
            Patient patient1 = new Patient();
            BeanUtils.copyProperties(patientDto, patient1);
            BeanUtils.copyProperties(patientDto, patient);
            return "Patient " + patient1.getFirstName() + " has been updated.";
        }
        return "There is no patient with this Id.";
    }

    @Override
    public String deletePatient(Long id) {
        patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("There is no patient with this Id."));

        Patient patient = new Patient();
        patientRepository.delete(patient);
        return null;
    }

    @Override
    public Optional<Patient> viewPatient(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if(patient.isPresent()) {
            patientRepository.findById(id);
            return patient;
        }
        return Optional.empty();
    }
}
