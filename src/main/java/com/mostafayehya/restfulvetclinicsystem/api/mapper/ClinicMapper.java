package com.mostafayehya.restfulvetclinicsystem.api.mapper;

import com.mostafayehya.restfulvetclinicsystem.api.dto.ClinicDTO;
import com.mostafayehya.restfulvetclinicsystem.domain.Clinic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClinicMapper {

    ClinicMapper INSTANCE = Mappers.getMapper(ClinicMapper.class);

    ClinicDTO clinicToClinicDTO(Clinic clinic);
    Clinic clinicDTOtoClinic(ClinicDTO clinicDTO);
}
