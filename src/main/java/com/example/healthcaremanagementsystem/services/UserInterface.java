package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.UserDto;

public interface UserInterface {
    String login (String email, String password);
    String logout();

    String registerUser(UserDto userDto);

}
