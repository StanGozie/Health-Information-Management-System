package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.Dto.HealthCareProviderDto;
import com.example.healthcaremanagementsystem.exceptions.HealthProviderNotFoundException;
import com.example.healthcaremanagementsystem.repositories.ProviderRepository;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import com.example.healthcaremanagementsystem.services.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProviderServiceImplementation implements ProviderService {

    private ProviderRepository healthProviderRepository;

    @Override
    public HealthCareProvider registerNewProvider(HealthCareProviderDto healthCareProviderDto) {

        HealthCareProvider healthCareProvider = new HealthCareProvider();
        BeanUtils.copyProperties(healthCareProviderDto, healthCareProvider);
        healthProviderRepository.save(healthCareProvider);
        return healthCareProvider;
    }

    @Override
    public HealthCareProvider updateProviderInformation(Long id, HealthCareProviderDto healthCareProviderDto) {
        Optional<HealthCareProvider> provider = healthProviderRepository.findById(id);
        if(provider.isPresent()) {
            HealthCareProvider healthCareProvider = new HealthCareProvider();
            BeanUtils.copyProperties(healthCareProviderDto, healthCareProvider);
            healthProviderRepository.save(healthCareProvider);
            return healthCareProvider;
        }
        return null;
    }

    @Override
    public HealthCareProvider viewProviderInformation(Long id) {
        Optional<HealthCareProvider> healthCareProvider = healthProviderRepository.findById(id);
        if(healthCareProvider.isPresent()) {
            return healthProviderRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public String deleteProviderInformation(Long id) {
        healthProviderRepository.deleteHealthCareProviderById(id).
                orElseThrow(() ->new HealthProviderNotFoundException("No Healthcare Provider found"));

        return "Healthcare Provider deleted";
    }
}
