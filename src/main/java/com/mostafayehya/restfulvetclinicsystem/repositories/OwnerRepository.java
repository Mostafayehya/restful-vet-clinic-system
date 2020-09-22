package com.mostafayehya.restfulvetclinicsystem.repositories;

import com.mostafayehya.restfulvetclinicsystem.domain.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
