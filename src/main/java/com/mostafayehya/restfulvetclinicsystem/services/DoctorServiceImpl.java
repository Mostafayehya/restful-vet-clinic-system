package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.DoctorDTO;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.DoctorMapper;
import com.mostafayehya.restfulvetclinicsystem.domain.Clinic;
import com.mostafayehya.restfulvetclinicsystem.domain.Doctor;
import com.mostafayehya.restfulvetclinicsystem.repositories.ClinicRepository;
import com.mostafayehya.restfulvetclinicsystem.repositories.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;
    private ClinicRepository clinicRepository;
    private DoctorMapper doctorMapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public DoctorDTO createNewDoctor(Long clinicId, DoctorDTO doctorDTO) {

        Optional<Clinic> optionalClinic = clinicRepository.findById(clinicId);

        // Todo very basic error handling, can be improved by throwing a global exception and intercepting it using
        // Aspects
        if (!optionalClinic.isPresent()) {
            log.error("Clinic is not found for id " + clinicId);
            return new DoctorDTO();
        }

        Clinic clinic = optionalClinic.get();

        Doctor convertedDoctor = doctorMapper.doctorDTOtoDoctor(doctorDTO);

        // 2-way binding
        convertedDoctor.setClinic(clinic);
        clinic.setDoctor(convertedDoctor);

        Clinic savedClinic = clinicRepository.save(clinic);
        return doctorMapper.doctorToDoctorDTO(savedClinic.getDoctor());
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .map(doctorMapper::doctorToDoctorDTO)
                .orElseThrow(RuntimeException::new);
    }
}
