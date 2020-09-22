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
public class ClinicDTO {

    private String name;
    private String address;
    private String phone;

    @JsonProperty("working_days_and_hours")
    private String workingDaysAndHours;

    private String email;
    private String urls;
}
