package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.HealthCareProviderDto;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import com.example.healthcaremanagementsystem.serviceImplementation.ProviderImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("api/v1")
@RequiredArgsConstructor
@RestController
public class HealthProviderController {

    private final ProviderImplementation providerImplementation;

    @PostMapping("register-provider")
    public String registerNewProvider(@RequestBody HealthCareProviderDto healthCareProviderDto){
        return providerImplementation.registerNewProvider(healthCareProviderDto);
    }

    @PutMapping("update-provider-info/{id}")
    public String updateProviderInformation(@PathVariable Long id, @RequestBody HealthCareProviderDto healthCareProviderDto){
        return providerImplementation.updateProviderInformation(id, healthCareProviderDto);
    }

    @GetMapping("view-provider/{id}")
    public Optional<HealthCareProvider> viewProviderInformation(@PathVariable Long id){
        return providerImplementation.viewProviderInformation(id);
    }

    @DeleteMapping("delete-provider/{name}")
    public String  deleteProviderInformation(@PathVariable String name){
        return providerImplementation.deleteProviderInformation(name);
    }
}
