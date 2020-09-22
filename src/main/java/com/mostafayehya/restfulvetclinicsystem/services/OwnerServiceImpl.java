package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.OwnerDTO;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.OwnerMapper;
import com.mostafayehya.restfulvetclinicsystem.domain.Owner;
import com.mostafayehya.restfulvetclinicsystem.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;
    private OwnerMapper ownerMapper;

    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
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
