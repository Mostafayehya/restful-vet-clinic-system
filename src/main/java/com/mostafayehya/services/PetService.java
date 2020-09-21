package com.mostafayehya.services;

import com.mostafayehya.api.dto.PetDTO;
import com.mostafayehya.repositories.PetRepository;
import com.mostafayehya.repositories.PhotoRepository;
import org.springframework.stereotype.Service;


public interface PetService {

    PetDTO createNewPet(PetDTO petDTO);

    PetDTO getPetById(Long id);

}
