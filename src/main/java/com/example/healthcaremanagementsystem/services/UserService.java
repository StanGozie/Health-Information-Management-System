package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.LoginRequestDto;
import com.example.healthcaremanagementsystem.Dto.UserDto;
import com.example.healthcaremanagementsystem.pojos.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ResponseEntity<String> login(LoginRequestDto request);
    String logout();

    ResponseEntity<String> registerUser(UserDto userDto);

}
