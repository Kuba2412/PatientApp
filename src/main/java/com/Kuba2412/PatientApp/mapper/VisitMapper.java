package com.Kuba2412.PatientApp.mapper;

import com.Kuba2412.PatientApp.dto.VisitDTO;
import com.Kuba2412.PatientApp.model.Visit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitMapper {

    VisitDTO toVisitDTO(Visit visit);

    Visit toVisit(VisitDTO visitDTO);
}
