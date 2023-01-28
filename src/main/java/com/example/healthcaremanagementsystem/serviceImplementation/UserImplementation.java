package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.Dto.UserDto;
import com.example.healthcaremanagementsystem.services.UserInterface;
import com.example.healthcaremanagementsystem.model.User;
import com.example.healthcaremanagementsystem.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserImplementation implements UserInterface {

    private final UserRepository userRepository;

    @Override
    public String registerUser(UserDto userDto) {
       User user = new User();
       user.setName(userDto.getName());
       user.setEmail(userDto.getEmail());
       user.setPassword(userDto.getPassword());
       user.setRole(userDto.getRole());
       user.setGender(userDto.getGender());
       userRepository.save(user);

       return "User registered successfully!";
    }

    @Override
    public String login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user == null){

            return "You are not registered. Kindly Sign up to continue.";
        }
        return "Welcome," + user.getName();
    }

    @Override
    public String logout() {
        return null;
    }


}
