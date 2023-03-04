package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.request.LabInvestigationDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface LabInvestigationService {

    ResponseEntity<ApiResponse> labTest (LabInvestigationDto labInvestigationDto);
}
