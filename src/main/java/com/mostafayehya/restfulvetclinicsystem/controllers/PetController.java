package com.mostafayehya.restfulvetclinicsystem.controllers;

import com.mostafayehya.restfulvetclinicsystem.api.dto.PetDTO;
import com.mostafayehya.restfulvetclinicsystem.services.OwnerService;
import com.mostafayehya.restfulvetclinicsystem.services.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetController {

    private final PetService petService;
    private final OwnerService ownerService;

    public PetController(PetService petService, OwnerService ownerService) {
        this.petService = petService;
        this.ownerService = ownerService;
    }

    @PostMapping("/api/owners/{ownerId}/pets")
    @ResponseStatus(HttpStatus.CREATED)
    public PetDTO createPet(@PathVariable Long ownerId, @RequestBody PetDTO petDTO) {
        return  petService.createNewPet(ownerId,petDTO);
    }

    @GetMapping({"/api/pets/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public PetDTO getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }
}
