package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.UserDto;
import com.example.healthcaremanagementsystem.repositories.UserRepository;
import com.example.healthcaremanagementsystem.serviceImplementation.UserImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserImplementation userImplementation;
    private final UserRepository userRepository;

    @PostMapping("/register-user")
    public String registerUser(@RequestBody UserDto userDto) {
        return userImplementation.registerUser(userDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody String email, @RequestBody String password) {
        return userImplementation.login(email, password);
    }
}
