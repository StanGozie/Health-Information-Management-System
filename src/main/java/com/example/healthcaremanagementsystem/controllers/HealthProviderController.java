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
    public String registerNewProvider(@RequestParam("email") String email, @RequestParam("password") String password, @RequestBody HealthCareProviderDto healthCareProviderDto){
        return providerImplementation.registerNewProvider(email, password, healthCareProviderDto);
    }

    @PutMapping("update-provider-info/{id}")
    public String updateProviderInformation(@RequestParam("email") String email, @RequestParam("password") String password, @PathVariable Long id, @RequestBody HealthCareProviderDto healthCareProviderDto){
        return providerImplementation.updateProviderInformation(email, password, id, healthCareProviderDto);
    }

    @GetMapping("view-provider/{id}")
    public Optional<HealthCareProvider> viewProviderInformation(@RequestParam("email") String email, @RequestParam("password") String password,@PathVariable Long id){
        return providerImplementation.viewProviderInformation(email, password, id);
    }

    @DeleteMapping("delete-provider/{name}")
    public String  deleteProviderInformation(@PathVariable String name){
        return providerImplementation.deleteProviderInformation(name);
    }
}
