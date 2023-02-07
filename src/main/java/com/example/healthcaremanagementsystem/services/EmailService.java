package com.example.healthcaremanagementsystem.services;

import com.example.healthcaremanagementsystem.Dto.EmailSenderDto;
import com.example.healthcaremanagementsystem.model.EmailDetails;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    void sendMail(EmailSenderDto emailSenderDto);

    //String sendMailWithAttachment(EmailSenderDto emailSenderDto);
}
