package com.mostafayehya.restfulvetclinicsystem.controllers;

import com.mostafayehya.restfulvetclinicsystem.api.dto.OwnerDTO;
import com.mostafayehya.restfulvetclinicsystem.services.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnerController {

    private final OwnerService ownerService;
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/api/owners")
    @ResponseStatus(HttpStatus.CREATED)
    public OwnerDTO addOwner(@RequestBody OwnerDTO ownerDTO) {
        return ownerService.createNewOwner(ownerDTO);
    }

    @GetMapping({"/api/owners/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public OwnerDTO getOwnerById(@PathVariable Long id) {
        return ownerService.getOwnerById(id);
    }
}
