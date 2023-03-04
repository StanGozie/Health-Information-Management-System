package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.request.HealthCareProviderDto;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProviderService {
    ResponseEntity<HealthCareProvider> registerNewProvider(HealthCareProviderDto healthCareProviderDto);
    ResponseEntity<HealthCareProvider> updateProviderInformation(Long id, HealthCareProviderDto healthCareProviderDto);
    Optional<HealthCareProvider> viewProviderInformation(Long id);
    ResponseEntity<String> deleteProviderInformation(Long id);
}
