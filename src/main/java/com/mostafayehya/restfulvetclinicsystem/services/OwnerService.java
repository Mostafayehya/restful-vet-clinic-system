package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.OwnerDTO;
import com.mostafayehya.restfulvetclinicsystem.api.dto.PetDTO;

public interface OwnerService {

    OwnerDTO createNewOwner(OwnerDTO ownerDTO);

    OwnerDTO getOwnerById(Long id);
}
