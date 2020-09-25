package com.mostafayehya.restfulvetclinicsystem.domain;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Pet pet;

    @OneToOne(cascade = CascadeType.ALL)
    private Doctor doctor;

    @OneToOne(cascade = CascadeType.ALL)
    private Clinic clinic;


    @Column(name = "date")
    String date;

    public Visit addDoctor(Doctor doctor){
        doctor.setVisit(this);
        this.doctor=doctor;
        return this;
    }

    public Visit addClinic(Clinic clinic){
        clinic.setVisit(this);
        this.clinic = clinic;
        return this;
    }

}
