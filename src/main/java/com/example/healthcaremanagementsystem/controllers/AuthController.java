package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.request.AuthenticationRequest;
import com.example.healthcaremanagementsystem.Dto.request.ChangePasswordDto;
import com.example.healthcaremanagementsystem.Dto.request.ResetPasswordDto;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("forgot-password")
    public ApiResponse<String> forgotPassword(@RequestParam String email){
        return userService.forgotPassword(email);
    }
    @PostMapping("reset-password")
    ApiResponse<String> resetPassword(@RequestBody ResetPasswordDto resetPasswordDTO){
        return userService.resetPassword(resetPasswordDTO);
    }
}
