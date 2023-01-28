package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.HealthCareProviderDto;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;


import java.util.Optional;

public interface ProviderInterface {
    String registerNewProvider(String email, String password, HealthCareProviderDto healthCareProviderDto);
    String updateProviderInformation(String email, String password, Long id, HealthCareProviderDto healthCareProviderDto);
    Optional<HealthCareProvider> viewProviderInformation(String email, String password, Long id);
    String deleteProviderInformation(String name);
}
