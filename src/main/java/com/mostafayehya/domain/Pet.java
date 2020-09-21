package com.mostafayehya.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private List<Photo> photos = new ArrayList<>();

    @Column(name = "weight")
    String weight;


}
