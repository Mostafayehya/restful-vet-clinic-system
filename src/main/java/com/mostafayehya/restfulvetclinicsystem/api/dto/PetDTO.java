package com.mostafayehya.restfulvetclinicsystem.api.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {

    private String name;
    private String gender;

    @JsonProperty("birthdate")
    private String dateOfBirth;

    @JsonProperty("animal_kind")
    private String animalKind;

    @JsonProperty("photo_url")
    private String photoUrl;

    private String weight;

    private Long ownerId;



}
