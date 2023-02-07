package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.LoginRequestDto;
import com.example.healthcaremanagementsystem.Dto.UserDto;
import com.example.healthcaremanagementsystem.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserService userInterface;

    @PostMapping("register-user")
    ResponseEntity<String> registerUser(UserDto userDto) {
        return userInterface.registerUser(userDto);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto request) {
        return userInterface.login(request);
    }
}

