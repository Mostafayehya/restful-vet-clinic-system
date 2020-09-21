package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.PetDTO;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.PetMapper;
import com.mostafayehya.restfulvetclinicsystem.domain.Pet;
import com.mostafayehya.restfulvetclinicsystem.repositories.PetRepository;
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
        return savedPetDTO;
    }

    @Override
    public PetDTO getPetById(Long id) {
        return petRepository.findById(id)
                .map(petMapper::petToPetDTO)
                .orElseThrow(RuntimeException::new);
    }
}
