package com.mostafayehya.restfulvetclinicsystem.api.mapper;

import com.mostafayehya.restfulvetclinicsystem.api.dto.ClinicDTO;
import com.mostafayehya.restfulvetclinicsystem.api.dto.DoctorDTO;
import com.mostafayehya.restfulvetclinicsystem.api.dto.PetDTO;
import com.mostafayehya.restfulvetclinicsystem.api.dto.VisitDTO;
import com.mostafayehya.restfulvetclinicsystem.domain.Clinic;
import com.mostafayehya.restfulvetclinicsystem.domain.Doctor;
import com.mostafayehya.restfulvetclinicsystem.domain.Pet;
import com.mostafayehya.restfulvetclinicsystem.domain.Visit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VisitMapper {

    VisitMapper INSTANCE = Mappers.getMapper(VisitMapper.class);

    VisitDTO visitToVisitDTO(Visit visit);

    Visit visitDTOtoVisit(VisitDTO visitDTO);

/*    ClinicDTO clinicToClinicDTO(Clinic clinic);

    Clinic clinicDTOtoClinic(ClinicDTO clinicDTO);

    DoctorDTO doctorToDoctorDTO(Doctor doctor);

    Doctor doctorDTOtoDoctor(DoctorDTO doctorDTO);

    PetDTO petToPetDTO(Pet pet);

    Pet PetDTOtoPet(PetDTO petDTO);*/
}
