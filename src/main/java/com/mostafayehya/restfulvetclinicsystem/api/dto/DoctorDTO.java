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
public class DoctorDTO {

    private String name;
    private String phone;

    @JsonProperty("photo_url")
    private String photoUrl;

    private String bio;
}
