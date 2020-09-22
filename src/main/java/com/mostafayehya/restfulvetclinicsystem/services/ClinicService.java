package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.ClinicDTO;

public interface ClinicService {

    ClinicDTO createNewClinic(ClinicDTO clinicDTODTO);

    ClinicDTO getClinicById(Long id);
}
