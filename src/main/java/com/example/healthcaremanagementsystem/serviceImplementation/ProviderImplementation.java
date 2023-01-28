package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.Dto.HealthCareProviderDto;
import com.example.healthcaremanagementsystem.enums.Role;
import com.example.healthcaremanagementsystem.exceptions.HealthProviderNotFoundException;
import com.example.healthcaremanagementsystem.model.User;
import com.example.healthcaremanagementsystem.repositories.HealthProviderRepository;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;


import com.example.healthcaremanagementsystem.repositories.UserRepository;
import com.example.healthcaremanagementsystem.services.ProviderInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProviderImplementation implements ProviderInterface {

    private HealthProviderRepository healthProviderRepository;
    private final UserRepository userRepository;

    @Override
    public String registerNewProvider(String email, String password, HealthCareProviderDto healthCareProviderDto) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user == null) {
            return "You are not a registered user.";
        }
        if(user.getRole() != Role.ADMIN) {
            return "You are not authorized to perform this action.";
        }
        HealthCareProvider healthCareProvider = new HealthCareProvider();
        BeanUtils.copyProperties(healthCareProviderDto, healthCareProvider);
        healthProviderRepository.save(healthCareProvider);
        return "New Provider Has Been Registered Successfully!";
    }

    @Override
    public String updateProviderInformation(String email, String password, Long id, HealthCareProviderDto healthCareProviderDto) {
        Optional<HealthCareProvider> provider = healthProviderRepository.findById(id);
        if(provider.isPresent()) {
            HealthCareProvider healthCareProvider = new HealthCareProvider();
            BeanUtils.copyProperties(healthCareProviderDto, healthCareProvider);
            healthProviderRepository.save(healthCareProvider);
            return "Provider information has been updated.";
        }
        return "No Provider found.";
    }

    @Override
    public Optional<HealthCareProvider> viewProviderInformation(String email, String password,Long id) {
        Optional<HealthCareProvider> provider = healthProviderRepository.findById(id);
        if(provider.isPresent()){
            return provider;
        }
        return null;
    }

    @Override
    public String  deleteProviderInformation(String name) {
        healthProviderRepository.deleteHealthCareProviderByName(name).
                orElseThrow(() ->new HealthProviderNotFoundException("No Provider Exists by this name"));

        return "Provider deleted successfully.";
    }
}
