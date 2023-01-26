package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.Dto.UserDto;
import com.example.healthcaremanagementsystem.interfaces.UserInterface;
import com.example.healthcaremanagementsystem.model.User;
import com.example.healthcaremanagementsystem.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor

public class UserImplementation implements UserInterface {

    private UserRepository userRepository;

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
        Optional<User> user = Optional.ofNullable(userRepository.findByEmailAndPassword(email, password));
        if(user.isPresent()){
            User user1 = new User();
            return "Welcome," + user1.getName();
        }
        return "User not registered. Kindly Sign up to continue.";
    }

    @Override
    public String logout() {
        return null;
    }


}
