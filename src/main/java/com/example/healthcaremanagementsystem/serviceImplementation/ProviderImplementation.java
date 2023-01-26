package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.Dto.HealthCareProviderDto;
import com.example.healthcaremanagementsystem.exceptions.HealthProviderNotFoundException;
import com.example.healthcaremanagementsystem.repositories.HealthProviderRepository;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;


import com.example.healthcaremanagementsystem.interfaces.ProviderInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service

public class ProviderImplementation implements ProviderInterface {

    private HealthProviderRepository healthProviderRepository;


    @Override
    public String registerNewProvider(HealthCareProviderDto healthCareProviderDto) {
        HealthCareProvider healthCareProvider = new HealthCareProvider();
        BeanUtils.copyProperties(healthCareProviderDto, healthCareProvider);
        healthProviderRepository.save(healthCareProvider);
        return "New Provider Has Been Registered Successfully!";
    }

    @Override
    public String updateProviderInformation(Long id, HealthCareProviderDto healthCareProviderDto) {
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
    public Optional<HealthCareProvider> viewProviderInformation(Long id) {
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
