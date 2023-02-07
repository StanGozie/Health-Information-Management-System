package com.example.healthcaremanagementsystem.Dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailSenderDto {

    private String to;
    private String subject;
    private String content;
    private String attachment;

}
