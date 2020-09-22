package com.mostafayehya.restfulvetclinicsystem.api.mapper;

import com.mostafayehya.restfulvetclinicsystem.api.dto.DoctorDTO;
import com.mostafayehya.restfulvetclinicsystem.domain.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    DoctorDTO doctorToDoctorDTO(Doctor doctor);

    Doctor doctorDTOtoDoctor(DoctorDTO doctorDTO);
}
