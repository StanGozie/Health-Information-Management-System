package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.Dto.request.HealthCareProviderDto;
import com.example.healthcaremanagementsystem.exceptions.ResourceNotFoundException;
import com.example.healthcaremanagementsystem.repositories.HealthCareProviderRepository;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import com.example.healthcaremanagementsystem.services.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProviderServiceImplementation implements ProviderService {

    private HealthCareProviderRepository healthProviderRepository;

    @Override
    public ResponseEntity<HealthCareProvider> registerNewProvider(HealthCareProviderDto healthCareProviderDto) {

        HealthCareProvider healthCareProvider = new HealthCareProvider();
        BeanUtils.copyProperties(healthCareProviderDto, healthCareProvider);
        healthProviderRepository.save(healthCareProvider);
        return ResponseEntity.ok(healthCareProvider);
    }

    @Override
    public ResponseEntity<HealthCareProvider> updateProviderInformation(Long id, HealthCareProviderDto healthCareProviderDto) {
        Optional<HealthCareProvider> provider = healthProviderRepository.findById(id);
        if(provider.isPresent()) {
            HealthCareProvider healthCareProvider = new HealthCareProvider();
            BeanUtils.copyProperties(healthCareProviderDto, healthCareProvider);
            healthProviderRepository.save(healthCareProvider);
            return ResponseEntity.ok(healthCareProvider);
        }
        return null;
    }

    @Override
    public Optional<HealthCareProvider> viewProviderInformation(Long id) {

        Optional<HealthCareProvider> healthCareProvider = healthProviderRepository.findById(id);

        if(healthCareProvider.isPresent())
            return healthCareProvider;

        return null;
    }

    @Override
    public ResponseEntity<String> deleteProviderInformation(Long id) {
        healthProviderRepository.deleteHealthCareProviderById(id).
                orElseThrow(() ->new ResourceNotFoundException("No Healthcare Provider found"));

        return ResponseEntity.ok("Healthcare Provider deleted");
    }
}
