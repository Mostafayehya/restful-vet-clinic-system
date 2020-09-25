package com.mostafayehya.restfulvetclinicsystem.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clinics")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "working_days")
    private String workingDaysAndHours; // Using String for simplicity

    @Column(name = "email")
    private String email;

    @Column(name = "social_networks")
    private String urls; // Possible URL entity

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clinic")
    Set<Doctor> doctors = new HashSet<>();

    @OneToOne
    Visit visit;

    public Clinic addDoctor(Doctor doc) {
        doc.setClinic(this);
        this.doctors.add(doc);
        return this;
    }

}
