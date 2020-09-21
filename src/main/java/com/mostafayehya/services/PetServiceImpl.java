package com.mostafayehya.services;

import com.mostafayehya.api.dto.PetDTO;
import com.mostafayehya.api.mapper.PetMapper;
import com.mostafayehya.domain.Pet;
import com.mostafayehya.repositories.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;
    private PetMapper petMapper;

    public PetServiceImpl(PetRepository petRepository, PetMapper petMapper) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    @Override
    public PetDTO createNewPet(PetDTO petDTO) {
        Pet pet = petMapper.PetDTOtoPet(petDTO);
        PetDTO savedPetDTO = petMapper.petToPetDTO(petRepository.save(pet));
        return petDTO;
    }

    @Override
    public PetDTO getPetById(Long id) {
        return petRepository.findById(id)
                .map(petMapper::petToPetDTO)
                .orElseThrow(RuntimeException::new);
    }
}
