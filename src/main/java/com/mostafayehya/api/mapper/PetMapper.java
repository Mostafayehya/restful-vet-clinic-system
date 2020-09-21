package com.mostafayehya.api.mapper;

import com.mostafayehya.api.dto.PetDTO;
import com.mostafayehya.domain.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PetMapper{

    PetMapper INSTANCE = Mappers.getMapper(PetMapper.class);

    PetDTO petToPetDTO(Pet pet);

    Pet PetDTOtoPet(PetDTO petDTO);
}
