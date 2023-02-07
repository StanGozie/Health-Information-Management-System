package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.AppUtils;
import com.example.healthcaremanagementsystem.Dto.LoginRequestDto;
import com.example.healthcaremanagementsystem.Dto.UserDto;
import com.example.healthcaremanagementsystem.config.CustomUserDetailsService;
import com.example.healthcaremanagementsystem.config.JwtAuthFilter;
import com.example.healthcaremanagementsystem.config.JwtUtils;
import com.example.healthcaremanagementsystem.services.EmailService;
import com.example.healthcaremanagementsystem.services.UserService;
import com.example.healthcaremanagementsystem.model.User;
import com.example.healthcaremanagementsystem.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtAuthFilter jwtAuthFilter;
    private final JwtUtils jwtUtils;
    private final AppUtils appUtils;
    private final CustomUserDetailsService userDetailsService;

    private final EmailService emailService;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<String> registerUser(UserDto userDto) {
        if (!appUtils.validEmail(userDto.getEmail()))
            return ResponseEntity.status(400).body("ERROR: EMAIL_INVALID");

        if (!userDto.getPassword().equals(userDto.getConfirmPassword()))
            return ResponseEntity.status(400).body("ERROR: PASSWORD_MISMATCH");

        Boolean isUserExist = userRepository.existsByEmail(userDto.getEmail());

        if (isUserExist)
            return ResponseEntity.status(400).body("ERROR:DUPLICATE_USER");

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setMiddleName(userDto.getMiddleName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setGender(userDto.getGender());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        String token = jwtUtils.generateSignUpConfirmationToken(userDto.getEmail());
        //user.setConfirmationToken(token);
        userRepository.save(user);

       return ResponseEntity.ok("Registration successful");
    }

    @Override
    public ResponseEntity<String> login(LoginRequestDto request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user = userDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtUtils.generateToken(user);
        Optional<User> users = userRepository.findByEmail(request.getEmail());
        if(users.isPresent()) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(400).body(null);
    }

    @Override
    public String logout() {
        return null;
    }


}
