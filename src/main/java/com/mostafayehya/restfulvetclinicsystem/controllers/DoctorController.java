package com.mostafayehya.restfulvetclinicsystem.controllers;

import com.mostafayehya.restfulvetclinicsystem.api.dto.DoctorDTO;
import com.mostafayehya.restfulvetclinicsystem.services.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/api/doctors")
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorDTO createDoctor(@RequestBody DoctorDTO doctorDTO) {
        return doctorService.createNewDoctor(doctorDTO);
    }

    @PostMapping("/api/clinics/{clinicId}/assign")
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorDTO assignDoctorToClinic(@PathVariable Long clinicId, @RequestBody DoctorDTO doctorDTO) {
        return doctorService.assignDoctorToClinic(clinicId, doctorDTO);
    }

    @GetMapping("/api/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorDTO getDoctor(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }
}
