package com.Kuba2412.PatientApp.controller;

import com.Kuba2412.PatientApp.client.PatientClient;
import com.Kuba2412.PatientApp.dto.VisitDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientClient patientClient;

    @Operation(summary = "Get visits by patient email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Visits retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Patient not found")
    })
    @GetMapping("/{email}/visits")
    public List<VisitDTO> getVisitsByPatientEmail(@PathVariable("email") String email) {
        return patientClient.getVisitsByPatientEmail(email);
    }

    @Operation(summary = "Register patient for a visit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Patient registered for visit successfully"),
            @ApiResponse(responseCode = "404", description = "Visit or Patient not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping("/visits/{visitId}/register")
    public void registerPatientForVisit(@PathVariable("visitId") Long visitId, @RequestParam("email") String email) {
        patientClient.registerPatientForVisit(visitId, email);
    }

    @Operation(summary = "Get visits by doctor ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Visits retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Doctor not found")
    })
    @GetMapping("/doctors/{doctorId}/visits")
    public List<VisitDTO> getVisitsByDoctorId(@PathVariable("doctorId") Long doctorId) {
        return patientClient.getVisitsByDoctorId(doctorId);
    }

    @Operation(summary = "Get available visits by doctor specialization and date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Available visits retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No available visits found for the specified criteria")
    })
    @GetMapping("/doctors/specialization/{specialization}/available-dates")
    public List<VisitDTO> getAvailableVisitsByDoctorSpecializationAndByDate(
            @PathVariable("specialization") String specialization,
        @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return patientClient.getAvailableVisitsByDoctorSpecializationAndByDate(specialization, date);
    }
}