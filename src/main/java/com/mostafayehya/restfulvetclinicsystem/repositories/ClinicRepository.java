package com.mostafayehya.restfulvetclinicsystem.repositories;

import com.mostafayehya.restfulvetclinicsystem.domain.Clinic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends CrudRepository<Clinic, Long> {
}
