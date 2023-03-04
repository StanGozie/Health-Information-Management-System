package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.request.EmailSenderDto;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendMail(EmailSenderDto emailSenderDto);

}
