package com.example.healthcaremanagementsystem.interfaces;

import com.example.healthcaremanagementsystem.Dto.HealthCareProviderDto;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;


import java.util.Optional;

public interface ProviderInterface {
    String registerNewProvider(HealthCareProviderDto healthCareProviderDto);
    String updateProviderInformation(Long id, HealthCareProviderDto providerDto);
    Optional<HealthCareProvider> viewProviderInformation(Long id);
     String deleteProviderInformation(String name);
}
