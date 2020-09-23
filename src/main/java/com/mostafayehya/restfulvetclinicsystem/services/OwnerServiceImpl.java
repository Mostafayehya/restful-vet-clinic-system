package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.OwnerDTO;
import com.mostafayehya.restfulvetclinicsystem.api.dto.PetDTO;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.OwnerMapper;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.PetMapper;
import com.mostafayehya.restfulvetclinicsystem.domain.Owner;
import com.mostafayehya.restfulvetclinicsystem.repositories.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;
    private OwnerMapper ownerMapper;
    private PetMapper petMapper;

    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerMapper ownerMapper, PetMapper petMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
        this.petMapper = petMapper;
    }

    @Override
    public List<PetDTO> getPetsByOwnerId(Long ownerId) {
        Optional<Owner> optionalOwner = ownerRepository.findById(ownerId);

        if (!optionalOwner.isPresent()) {
            log.error("can't find owner with id " + ownerId);
            return new ArrayList<>();
        }
        Owner owner = optionalOwner.get();
        return owner.getPetList().stream()
                .map(petMapper::petToPetDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerDTO createNewOwner(OwnerDTO ownerDTO) {
        Owner owner = ownerMapper.ownerDTOtoOwner(ownerDTO);
        OwnerDTO saveOwnerDTO = ownerMapper.ownerToOwnerDTO(ownerRepository.save(owner));
        return saveOwnerDTO;
    }

    @Override
    public OwnerDTO getOwnerById(Long id) {
        return ownerRepository.findById(id)
                .map(ownerMapper::ownerToOwnerDTO)
                .orElseThrow(RuntimeException::new);
    }
}
