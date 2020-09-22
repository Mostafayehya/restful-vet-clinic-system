package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.OwnerDTO;
import com.mostafayehya.restfulvetclinicsystem.api.dto.PetDTO;

import java.util.List;

public interface OwnerService {

    List<PetDTO> getPetsByOwnerId(Long ownerId);

    OwnerDTO createNewOwner(OwnerDTO ownerDTO);

    OwnerDTO getOwnerById(Long id);
}
