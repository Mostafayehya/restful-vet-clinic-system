package com.mostafayehya.controllers;

import com.mostafayehya.api.dto.PetDTO;
import com.mostafayehya.services.PetService;
import org.springframework.http.HttpStatus;
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

        return petService.createNewPet(petDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PetDTO getPetById(@PathVariable Long id) {

        return petService.getPetById(id);
    }
}
