package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.AppUtil;
import com.example.healthcaremanagementsystem.Dto.request.*;
import com.example.healthcaremanagementsystem.Dto.response.ApiResponse;
import com.example.healthcaremanagementsystem.config.CustomUserDetailsService;
import com.example.healthcaremanagementsystem.config.JwtAuthFilter;
import com.example.healthcaremanagementsystem.config.JwtUtils;
import com.example.healthcaremanagementsystem.exceptions.ResourceNotFoundException;
import com.example.healthcaremanagementsystem.exceptions.UserNotFoundException;
import com.example.healthcaremanagementsystem.model.HealthCareProvider;
import com.example.healthcaremanagementsystem.model.User;
import com.example.healthcaremanagementsystem.repositories.HealthCareProviderRepository;
import com.example.healthcaremanagementsystem.repositories.UserRepository;
import com.example.healthcaremanagementsystem.services.EmailService;
import com.example.healthcaremanagementsystem.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor

public class UserServiceImplementation implements UserService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    private final JwtAuthFilter jwtAuthFilter;
    private final JwtUtils jwtUtils;
    private final AppUtil appUtils;
    private final CustomUserDetailsService userDetailsService;
    private final EmailService emailService;
    private final UserRepository userRepository;

    private final HealthCareProvider healthCareProvider;
    private final HealthCareProviderRepository providerRepository;


    @Override
    public ResponseEntity<ApiResponse> signUp(SignUpRequest signUpRequest) throws ValidationException {

        if (!appUtils.validEmail(signUpRequest.getEmail()))
            throw new ValidationException("Email is invalid");

        Boolean isUserExist = userRepository.existsByEmail(signUpRequest.getEmail());

        if (isUserExist)
            throw new ValidationException("User Already Exists!");

        if (!(Objects.equals(signUpRequest.getConfirmPassword(), signUpRequest.getPassword())))
            throw new ValidationException("Passwords do not match");

        User newUser = new User();
        newUser.setFirstName(signUpRequest.getFirstName());
        newUser.setMiddleName(signUpRequest.getMiddleName());
        newUser.setLastName(signUpRequest.getLastName());
        newUser.setEmail(signUpRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        String token = jwtUtils.generateSignUpConfirmationToken(signUpRequest.getEmail());
        newUser.setIsActive(false);
        newUser.setConfirmationToken(token);
        userRepository.save(newUser);

        String body = "<h3>Hello " + signUpRequest.getFirstName() +
                "<br> Copy the link below to activate your account <br>Token :</h3>" + token;
        String subject = "Patient Health Information App";

        EmailSenderDto emailSenderDto = new EmailSenderDto();
        emailService.sendMail(emailSenderDto);
        return ResponseEntity.ok(new ApiResponse<>("Successful", "SignUp Successful. Check your mail to activate your account", null));
    }

    @Override
    public ResponseEntity<ApiResponse> confirmSignUp(ConfirmSignUpDto confirmSignUpDto) throws UserNotFoundException {

        Optional<User> existingUser = userRepository.findByConfirmationToken(confirmSignUpDto.getConfirmationToken());
        if (existingUser.isEmpty())
            throw new UserNotFoundException("User not found");
        existingUser.get().setIsActive(true);
        userRepository.save(existingUser.get());

        return ResponseEntity.ok(new ApiResponse<>("Successful", "Account verification successful", null));
    }

    @Override
    public ResponseEntity<ApiResponse> completeRegistration(CompleteRegistrationDto completeRegistrationDto) throws ResourceNotFoundException {

        User user = appUtils.getLoggedInUser();

        user.setGender(completeRegistrationDto.getGender());
        user.setRole(completeRegistrationDto.getRole());
        user.setDob(user.getDob());
        userRepository.save(user);

        return ResponseEntity.ok(new ApiResponse<>("Success", "Registration successful", null));
    }

    @Override
    public ResponseEntity<ApiResponse> selectHealthProvider(ChooseProviderDto chooseProviderDto) throws ResourceNotFoundException {

        User user = appUtils.getLoggedInUser();

        Optional<HealthCareProvider> healthCareProvider1 = providerRepository.findByName(chooseProviderDto.getHealthcareProviderName());
        if (healthCareProvider1.isEmpty()) {
            throw new ResourceNotFoundException("HealthCare Provider Not Found");
        }

        user.setHealthCareProviderName(chooseProviderDto.getHealthcareProviderName());
        userRepository.save(user);

        return ResponseEntity.ok(new ApiResponse<>("Successful", "HealthCare Provider Added", null));
    }

    @Override
    public ResponseEntity<String> login(AuthenticationRequest authenticationRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        UserDetails user = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return ResponseEntity.ok(jwtUtils.generateToken(user));
    }

    @Override
    public ResponseEntity<ApiResponse> changePassword(ChangePasswordDto changePasswordDto) {
        User user = appUtils.getLoggedInUser();

        if (!(Objects.equals(changePasswordDto.getNewPassword(), changePasswordDto.getConfirmNewPassword()))) {
            throw new InputMismatchException("Confirm new password does not match!");
        }
        user.setPassword(passwordEncoder.encode(changePasswordDto.getNewPassword()));
        userRepository.save(user);

        return ResponseEntity.ok(new ApiResponse<>("Success", "Your password has been changed!", null));
    }

    @Override
    public String logout() {
        return null;
    }

    @Override
    public ApiResponse<String> forgotPassword(String email) {

        Boolean isEmailExist = userRepository.existsByEmail(email);
        if (!isEmailExist)
            throw new UserNotFoundException("User Does Not Exist!");

        User user = new User();
        String token = jwtUtils.generateToken(userDetailsService.loadUserByUsername(user.getEmail()));
        user.setConfirmationToken(token);
        userRepository.save(user);

        String resetPasswordLink = "http://localhost:8081/api/v1/resetPassword" + token;
        String resetLink = "<h3>Hello " + user.getFirstName() + ",<br> Click the link below to reset your password <a href=" + resetPasswordLink + "><br>Reset Password</a></h3>";

        EmailSenderDto emailSenderDto = new EmailSenderDto();
        emailService.sendMail(emailSenderDto);

        return new ApiResponse<>(null, "A password reset link has been sent to your email", null);
    }

    @Override
    public ApiResponse<String> resetPassword(ResetPasswordDto resetPasswordDTO) {
        Optional<User> user = userRepository.findByConfirmationToken(resetPasswordDTO.getToken());

        if(user.isEmpty())
            throw new ValidationException("Token incorrect!");

        if(! resetPasswordDTO.getConfirmPassword().equals(resetPasswordDTO.getNewPassword())) {
            throw new InputMismatchException("Passwords do not match!");
        }

        User user1 = new User();
        user1.setPassword(passwordEncoder.encode(resetPasswordDTO.getNewPassword()));
        userRepository.save(user1);

        return new ApiResponse<String>("Success", "password reset successful", null);
    }

}