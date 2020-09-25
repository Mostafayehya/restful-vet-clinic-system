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
public class VisitDTO {

    @JsonProperty("pet")
    private PetDTO pet;
    @JsonProperty("doctor")
    private DoctorDTO doctor;
    @JsonProperty("clinic")
    private ClinicDTO clinic;
    private String date;

}
