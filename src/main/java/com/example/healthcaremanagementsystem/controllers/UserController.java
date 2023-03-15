package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.request.ChooseProviderDto;
import com.example.healthcaremanagementsystem.Dto.request.CompleteRegistrationDto;
import com.example.healthcaremanagementsystem.Dto.request.ConfirmSignUpDto;
import com.example.healthcaremanagementsystem.Dto.request.SignUpRequest;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("complete-registration")
    ResponseEntity<ApiResponse> completeRegistration(@RequestBody CompleteRegistrationDto completeRegistrationDto) {
        return userService.completeRegistration(completeRegistrationDto);
    }

    @PostMapping("sign-up")
    public ResponseEntity<ApiResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        return userService.signUp(signUpRequest); }

    @PostMapping("confirm-signup")
    public ResponseEntity<ApiResponse> confirmRegistration(@RequestBody ConfirmSignUpDto confirmSignUpDto) {
        return userService.confirmSignUp(confirmSignUpDto);
    }

    @PostMapping("choose-provider")
    public ResponseEntity<ApiResponse> selectHealthProvider(@RequestBody ChooseProviderDto chooseProviderDto){
        return userService.selectHealthProvider(chooseProviderDto);
    }



}

