package com.mostafayehya.restfulvetclinicsystem.controllers;

import com.mostafayehya.restfulvetclinicsystem.api.dto.PetDTO;
import com.mostafayehya.restfulvetclinicsystem.services.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;
    Logger logger = LoggerFactory.getLogger(PetController.class);


    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<PetDTO> addPet(@RequestBody PetDTO petDTO) {

        logger.debug("============================ addPet was called  =============================");
        return new ResponseEntity<>(petService.createNewPet(petDTO), HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<PetDTO> getPetById(@PathVariable Long id) {
        logger.debug("============================ getPetById was called=============================");
        return new ResponseEntity<>(petService.getPetById(id), HttpStatus.OK);
    }
}
