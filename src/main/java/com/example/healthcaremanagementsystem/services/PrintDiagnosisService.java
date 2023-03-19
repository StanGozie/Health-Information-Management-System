package com.example.healthcaremanagementsystem.services;


import com.lowagie.text.Document;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface PrintDiagnosisService {

     ResponseEntity<Document> export(Long id, String uuid, HttpServletResponse response) throws IOException;
}
