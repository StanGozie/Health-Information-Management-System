package com.example.healthcaremanagementsystem.interfaces;

import com.example.healthcaremanagementsystem.Dto.UserDto;
import com.example.healthcaremanagementsystem.model.User;

import java.util.Optional;

public interface UserInterface {
    String login (String email, String password);
    String logout();

    String registerUser(UserDto userDto);

}
