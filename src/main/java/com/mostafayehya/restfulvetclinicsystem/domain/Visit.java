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
    Pet pet;

    @OneToOne(cascade = CascadeType.ALL)
    Doctor doctor;

    @OneToOne(cascade = CascadeType.ALL)
    Clinic clinic;

    @Column(name = "date")
    String date;

}
