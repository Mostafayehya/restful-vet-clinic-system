package com.mostafayehya.restfulvetclinicsystem.domain;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    Set<Pet> petList = new HashSet<>();

    // To Bind each pet to a specic owner
    public Owner addPet(Pet convertedPet) {
        convertedPet.setOwner(this);
        this.petList.add(convertedPet);
        return this;
    }
}
