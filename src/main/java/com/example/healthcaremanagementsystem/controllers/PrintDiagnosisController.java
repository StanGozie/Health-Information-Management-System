package com.example.healthcaremanagementsystem.controllers;

import com.example.healthcaremanagementsystem.services.PrintDiagnosisService;
import com.lowagie.text.Document;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transactions/")
public class PrintDiagnosisController {
        private final PrintDiagnosisService printDiagnosis;


        @PreAuthorize("hasRole('ROLE_DOCTOR')")
        @GetMapping("generate-receipt/{id}/{uuid}")
        public ResponseEntity<Document> export(@PathVariable Long id, @PathVariable String uuid, HttpServletResponse response) throws IOException {
            response.setContentType("application/pdf");
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy:hh:mm:ss");
            String currentDateTime = dateFormat.format(new Date());
            String headerKey = "Content-Disposition";
            String headerValue = "attachment: Transaction Receipt " + currentDateTime + ".pdf";
            response.setHeader(headerKey, headerValue);

            return printDiagnosis.export(id, uuid, response);
        }
    }

