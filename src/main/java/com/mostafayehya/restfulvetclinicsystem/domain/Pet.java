package com.mostafayehya.restfulvetclinicsystem.domain;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private String dateOfBirth; // used string date for easier mapping, can be refactored and use a custom mapper

    @Column(name = "animal_kind")
    private String animalKind;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "weight")
    String weight;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    Owner owner;



}
