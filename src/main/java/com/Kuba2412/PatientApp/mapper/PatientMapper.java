package com.Kuba2412.PatientApp.mapper;

import com.Kuba2412.PatientApp.dto.PatientDTO;
import com.Kuba2412.PatientApp.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    PatientDTO toPatientDTO(Patient patient);

    Patient toPatient(PatientDTO patientDTO);
}
