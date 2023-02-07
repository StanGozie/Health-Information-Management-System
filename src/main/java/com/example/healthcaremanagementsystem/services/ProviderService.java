package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.HealthCareProviderDto;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public interface ProviderService {
    HealthCareProvider registerNewProvider(HealthCareProviderDto healthCareProviderDto);
    HealthCareProvider updateProviderInformation(Long id, HealthCareProviderDto healthCareProviderDto);
    HealthCareProvider viewProviderInformation(Long id);
    String deleteProviderInformation(Long id);
}
