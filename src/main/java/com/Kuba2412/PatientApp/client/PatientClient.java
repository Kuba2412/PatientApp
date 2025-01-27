package com.Kuba2412.PatientApp.client;

import com.Kuba2412.PatientApp.dto.VisitDTO;
import com.Kuba2412.PatientApp.fallback.PatientClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "medical-clinic", configuration = FeignClientProperties.FeignClientConfiguration.class, fallback = PatientClientFallback.class)
public interface PatientClient {

    @GetMapping("/patients/{email}/visits")
    List<VisitDTO> getVisitsByPatientEmail(@PathVariable("email") String email);

    @PostMapping("/visits/{visitId}/register")
    void registerPatientForVisit(@PathVariable("visitId") Long visitId, @RequestParam("email") String email);

    @GetMapping("/doctors/{doctorId}/visits")
    List<VisitDTO> getVisitsByDoctorId(@PathVariable("doctorId") Long doctorId);

    @GetMapping("/doctors/specialization/{specialization}/available-dates")
    List<VisitDTO> getAvailableVisitsByDoctorSpecializationAndByDate(
            @PathVariable("specialization") String specialization,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date);
}
