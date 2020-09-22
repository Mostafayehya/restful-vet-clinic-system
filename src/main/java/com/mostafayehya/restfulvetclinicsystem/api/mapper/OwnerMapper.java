package com.mostafayehya.restfulvetclinicsystem.api.mapper;

import com.mostafayehya.restfulvetclinicsystem.api.dto.OwnerDTO;
import com.mostafayehya.restfulvetclinicsystem.domain.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OwnerMapper {

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

    OwnerDTO ownerToOwnerDTO(Owner owner);

    Owner ownerDTOtoOwner(OwnerDTO ownerDTO);
}
