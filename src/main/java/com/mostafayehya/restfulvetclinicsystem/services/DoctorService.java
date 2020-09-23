package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.DoctorDTO;

public interface DoctorService {

    DoctorDTO createNewDoctor(DoctorDTO doctorDTO);
    DoctorDTO assignDoctorToClinic(Long clinicId, DoctorDTO doctorDTO);
    DoctorDTO getDoctorById(Long id);

    void deassignDoctorToClinic(Long clinicId, DoctorDTO doctorDTO);
}
