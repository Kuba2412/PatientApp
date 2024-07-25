package com.Kuba2412.PatientApp.mapper;

import com.Kuba2412.PatientApp.dto.DoctorDTO;
import com.Kuba2412.PatientApp.model.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    DoctorDTO toDoctorDTO(Doctor doctor);

    Doctor toDoctor(DoctorDTO doctorDTO);
}
