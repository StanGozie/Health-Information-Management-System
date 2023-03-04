package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.request.LabInvestigationDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.services.LabInvestigationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class LabInvestigationController {
    private final LabInvestigationService labInvestigationService;

    @PreAuthorize("hasRole('ROLE_INVESTIGATOR')")
    @PostMapping("/lab-test")
    public ResponseEntity<ApiResponse> labTest(@RequestBody LabInvestigationDto labInvestigationDto) {
        return labInvestigationService.labTest(labInvestigationDto);
    }
}
