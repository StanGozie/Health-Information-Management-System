package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.HealthCareProviderDto;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import com.example.healthcaremanagementsystem.serviceImplementation.ProviderServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class HealthProviderController {

    private final ProviderServiceImplementation providerImplementation;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("register-provider")
    public HealthCareProvider registerNewProvider(@RequestBody HealthCareProviderDto healthCareProviderDto){
        return providerImplementation.registerNewProvider(healthCareProviderDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update-provider-info")
    public HealthCareProvider updateProviderInformation(@RequestParam Long id, @RequestBody HealthCareProviderDto healthCareProviderDto){
        return providerImplementation.updateProviderInformation(id, healthCareProviderDto);
    }
    @GetMapping("view-provider")
    public HealthCareProvider viewProviderInformation(@RequestBody Long id){
        return providerImplementation.viewProviderInformation(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete-provider")
    public String deleteProviderInformation(Long id){
        return providerImplementation.deleteProviderInformation(id);
    }
}
