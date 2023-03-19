package com.example.healthcaremanagementsystem.serviceImplementation;

import com.example.healthcaremanagementsystem.AppUtil;
import com.example.healthcaremanagementsystem.model.Diagnosis;
import com.example.healthcaremanagementsystem.model.User;
import com.example.healthcaremanagementsystem.repositories.DiagnosisRepository;
import com.example.healthcaremanagementsystem.repositories.PatientRepository;
import com.example.healthcaremanagementsystem.services.PrintDiagnosisService;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.lang.module.ResolutionException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrintDiagnosisServiceImpl implements PrintDiagnosisService {

    private final PatientRepository patientRepository;
    private final DiagnosisRepository diagnosisRepository;
    private final AppUtil appUtil;


//    public ApiResponse<Object> export(String uuid, HttpServletResponse response) throws DocumentException, IOException {
//
//        HealthInformationPdf healthInformationPdf = new HealthInformationPdf();
//
//        Optional<Patient> patient = patientRepository.findByUuid(uuid);
//        if (patient.isEmpty()) {
//            throw new ValidationException("Patient Not Found");
//        }
//        Document document = new Document(PageSize.A4);
//        PdfWriter.getInstance(document, response.getOutputStream());
//
//        document.open();
//        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//        font.setSize(18);
//        font.setColor(Color.BLUE);
//
//        Paragraph p = new Paragraph("Patient Information", font);
//        p.setAlignment(Paragraph.ALIGN_CENTER);
//
//        healthInformationPdf.setFirstName(String.valueOf(patient.get().getFirstName()));
//        healthInformationPdf.setMiddleName(String.valueOf(patient.get().getMiddleName()));
//        healthInformationPdf.setLastName(String.valueOf(patient.get().getLastName()));
//        healthInformationPdf.setOccupation(String.valueOf(patient.get().getOccupation()));
//
//        Paragraph c = new Paragraph(String.valueOf(healthInformationPdf));
//        c.setFont(FontFactory.getFont(FontFactory.COURIER));
//        c.setAlignment(Element.ALIGN_LEFT);
//
////        PdfPTable table = new PdfPTable(5);
////        table.setWidthPercentage(100f);
////        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
////        table.setSpacingBefore(10);
////
////        writeTableHeader(table);
////        writeTableData(table);
//
//        document.add(p);
//        document.add(c);
//
//        document.close();
//
//        return ApiResponse.builder()
//                .data(document)
//                .build();
//    }

    @Override
    public ResponseEntity<Document> export(Long id, String uuid, HttpServletResponse response) throws IOException {
        User user = appUtil.getLoggedInUser();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy:  hh:mm:ss");
        String currentDateTime = dateFormat.format(new Date());

        Optional<Diagnosis> diagnosis = diagnosisRepository.findByIdAndUuid(id,uuid);
        if(diagnosis.isEmpty())
            throw new ResolutionException("No diagnosis found for this patient");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD);
        font.setSize(20);
        font.setColor(Color.BLACK);
        Paragraph p = new Paragraph("Patient Diagnosis", font);
        p.setAlignment(Element.ALIGN_CENTER);

        Paragraph p1 = new Paragraph();
        p1.setFont(FontFactory.getFont(FontFactory.TIMES_ROMAN));
        p1.setAlignment(Element.ALIGN_LEFT);
        p1.setMultipliedLeading(4);
        p1.add ("Patient Name: " + diagnosis.get().getPatientFirstName() + " " + diagnosis.get().getPatientLastName() + '\n' +
                "Patient's Uuid: " + diagnosis.get().getUuid() + '\n' +
                "Diagnosis: " + diagnosis.get().getDiagnosis() + '\n' +
                "Prescription: " + diagnosis.get().getPrescription() + '\n' +
                "Hospital Visited: " + diagnosis.get().getHospitalVisited() + '\n' +
                "Physician's name: " + diagnosis.get().getPhysicianName() + '\n' +
                "Date of Diagnosis: " + diagnosis.get().getCreatedAt() + '\n' +
                "Current Date: " + currentDateTime);

        document.add(p);
        document.add(p1);
        document.close();

        return ResponseEntity.ok(document);
    }
}
