package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.Dto.UserDto;
import com.example.healthcaremanagementsystem.repositories.UserRepository;
import com.example.healthcaremanagementsystem.serviceImplementation.UserImplementation;
import com.example.healthcaremanagementsystem.services.UserInterface;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserInterface userInterface;

    @PostMapping("/register-user")
    public String registerUser(@RequestBody UserDto userDto) {
        return userInterface.registerUser(userDto);
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        return userInterface.login(email, password);
    }
}

