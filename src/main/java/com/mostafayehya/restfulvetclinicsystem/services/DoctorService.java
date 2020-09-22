package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.DoctorDTO;

public interface DoctorService {

    DoctorDTO createNewDoctor(Long clinicId,DoctorDTO doctorDTO);

    DoctorDTO getDoctorById(Long id);
}
