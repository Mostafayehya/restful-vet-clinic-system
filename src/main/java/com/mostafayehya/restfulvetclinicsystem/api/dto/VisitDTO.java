package com.mostafayehya.restfulvetclinicsystem.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VisitDTO {

    private PetDTO petDTO;
    private DoctorDTO doctorDTO;
    private ClinicDTO clinicDTO;
    private String date;

}
