package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.request.HealthCareProviderDto;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import com.example.healthcaremanagementsystem.services.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class HealthProviderController {

    @Autowired
    private ProviderService providerService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("register-provider")
    public ResponseEntity<HealthCareProvider> registerNewProvider(@RequestBody HealthCareProviderDto healthCareProviderDto){
        return providerService.registerNewProvider(healthCareProviderDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update-provider-info")
    public ResponseEntity<HealthCareProvider> updateProviderInformation(@RequestParam Long id, @RequestBody HealthCareProviderDto healthCareProviderDto){
        return providerService.updateProviderInformation(id, healthCareProviderDto);
    }
    @GetMapping("view-provider")
    public Optional<HealthCareProvider> viewProviderInformation(@RequestParam Long id){
        return providerService.viewProviderInformation(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete-provider")
    public ResponseEntity<String> deleteProviderInformation(Long id){
        return providerService.deleteProviderInformation(id);
    }
}
