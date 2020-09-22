package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.ClinicDTO;
import com.mostafayehya.restfulvetclinicsystem.api.dto.DoctorDTO;

import java.util.List;

public interface ClinicService {

    ClinicDTO createNewClinic(ClinicDTO clinicDTODTO);

    ClinicDTO getClinicById(Long id);

    List<DoctorDTO> getAllDoctors(Long ClinicId);
}
