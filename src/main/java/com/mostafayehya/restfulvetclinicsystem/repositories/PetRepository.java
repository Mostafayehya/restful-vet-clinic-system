package com.mostafayehya.restfulvetclinicsystem.repositories;

import com.mostafayehya.restfulvetclinicsystem.domain.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet,Long> {
}
