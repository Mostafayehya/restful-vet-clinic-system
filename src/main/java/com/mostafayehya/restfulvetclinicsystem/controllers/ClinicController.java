package com.mostafayehya.restfulvetclinicsystem.controllers;

import com.mostafayehya.restfulvetclinicsystem.api.dto.ClinicDTO;
import com.mostafayehya.restfulvetclinicsystem.services.ClinicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClinicController {

    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @PostMapping("/api/clinics")
    @ResponseStatus(HttpStatus.CREATED)
    public ClinicDTO addClinic(@RequestBody ClinicDTO clinicDTO) {
        return clinicService.createNewClinic(clinicDTO);
    }

    @GetMapping({"/api/clinics/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ClinicDTO getClinicById(@PathVariable Long id) {
        return clinicService.getClinicById(id);
    }
}
