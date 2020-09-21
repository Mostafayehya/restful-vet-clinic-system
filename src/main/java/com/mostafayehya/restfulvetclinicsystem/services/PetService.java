package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.PetDTO;

public interface PetService {

    PetDTO createNewPet(PetDTO petDTO);

    PetDTO getPetById(Long id);

}
