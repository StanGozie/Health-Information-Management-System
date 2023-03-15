package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.request.AuthenticationRequest;
import com.example.healthcaremanagementsystem.Dto.request.ChangePasswordDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class AuthController {

    private final UserService userService;
    @PostMapping("/authenticate")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequest authenticationRequest) {
        return userService.login(authenticationRequest);
    }
    @PostMapping("changePassword")
    public ResponseEntity<ApiResponse> changePassword(@RequestBody ChangePasswordDto changePasswordDto) {
        return userService.changePassword(changePasswordDto);
    }
}