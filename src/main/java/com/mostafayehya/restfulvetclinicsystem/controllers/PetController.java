package com.mostafayehya.restfulvetclinicsystem.controllers;

import com.mostafayehya.restfulvetclinicsystem.api.dto.PetDTO;
import com.mostafayehya.restfulvetclinicsystem.services.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;
    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetDTO addPet(@RequestBody PetDTO petDTO) {

        return  petService.createNewPet(petDTO);
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public PetDTO getPetById(@PathVariable Long id) {
        return petService.getPetById(id);
    }
}
