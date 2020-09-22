package com.mostafayehya.restfulvetclinicsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mostafayehya.restfulvetclinicsystem.domain.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OwnerDTO {

    private String name;
    private String gender;
    private String email;
    private String phone;
    private String address;

    @JsonProperty("pet_list")
    Set<PetDTO> petList = new HashSet<>();


}
