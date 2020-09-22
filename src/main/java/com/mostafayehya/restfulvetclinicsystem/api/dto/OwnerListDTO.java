package com.mostafayehya.restfulvetclinicsystem.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerListDTO {

    List<OwnerDTO> owners;
}
