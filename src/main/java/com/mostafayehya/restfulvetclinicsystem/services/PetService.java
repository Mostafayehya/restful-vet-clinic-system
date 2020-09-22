package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.PetDTO;

public interface PetService {

    PetDTO createNewPet(Long ownerId,PetDTO petDTO);

    PetDTO getPetById(Long id);

}
