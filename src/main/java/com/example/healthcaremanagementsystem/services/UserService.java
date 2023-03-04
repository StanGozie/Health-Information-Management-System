package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.request.*;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface UserService {
    String logout();
    ResponseEntity<ApiResponse> completeRegistration(CompleteRegistrationDto completeRegistrationDto);
    ResponseEntity<ApiResponse> signUp(SignUpRequest signUpRequest);

    ResponseEntity<ApiResponse> confirmSignUp(ConfirmSignUpDto confirmSignUpDto);

    ResponseEntity<ApiResponse> selectHealthProvider (ChooseProviderDto chooseProviderDto);

    ResponseEntity<String> login(AuthenticationRequest authenticationRequest);

}
