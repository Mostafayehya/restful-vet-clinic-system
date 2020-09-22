package com.mostafayehya.restfulvetclinicsystem.repositories;

import com.mostafayehya.restfulvetclinicsystem.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
