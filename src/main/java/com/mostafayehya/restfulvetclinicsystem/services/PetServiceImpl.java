package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.PetDTO;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.PetMapper;
import com.mostafayehya.restfulvetclinicsystem.domain.Owner;
import com.mostafayehya.restfulvetclinicsystem.domain.Pet;
import com.mostafayehya.restfulvetclinicsystem.repositories.OwnerRepository;
import com.mostafayehya.restfulvetclinicsystem.repositories.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;
    private OwnerRepository ownerRepository;
    private PetMapper petMapper;


    public PetServiceImpl(PetRepository petRepository, OwnerRepository ownerRepository, PetMapper petMapper) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.petMapper = petMapper;
    }

    @Override
    public PetDTO createNewPet(Long ownerId, PetDTO petDTO) {

        Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);

        // Todo very basic error handling, can be improved by throwing a global exception and intercepting it using
        // Aspects
        if (!optionalOwner.isPresent()) {
            log.error("Owner is not found for id " + ownerId);
            return new PetDTO();
        }

        Owner owner = optionalOwner.get();

        Pet convertedPet = petMapper.PetDTOtoPet(petDTO);

        // 2-way binding
        convertedPet.setOwner(owner);
        owner.addPet(convertedPet);

        Owner savedOwner = ownerRepository.save(owner);

        Optional<Pet> savedPetOptional = savedOwner.getPetList().stream()
                .filter(pet -> pet.getAnimalKind().equals(petDTO.getAnimalKind()))
                .filter(pet -> pet.getName().equals(petDTO.getName()))
                .filter(pet -> pet.getWeight().equals(petDTO.getWeight()))
                .findFirst();

        return petMapper.petToPetDTO(savedPetOptional.get());
    }

    @Override
    public PetDTO getPetById(Long id) {
        return petRepository.findById(id)
                .map(petMapper::petToPetDTO)
                .orElseThrow(RuntimeException::new);
    }
}
