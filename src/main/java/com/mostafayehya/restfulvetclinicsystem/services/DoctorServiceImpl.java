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

    public DoctorServiceImpl(DoctorRepository doctorRepository, ClinicRepository clinicRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.clinicRepository = clinicRepository;
        this.doctorMapper = doctorMapper;
    }

    @Override
    public DoctorDTO createNewDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.doctorDTOtoDoctor(doctorDTO);
        DoctorDTO savedDoctorDTO = doctorMapper.doctorToDoctorDTO(doctorRepository.save(doctor));
        return savedDoctorDTO;
    }

    @Override
    public DoctorDTO assignDoctorToClinic(Long clinicId, DoctorDTO doctorDTO) {

        Optional<Clinic> optionalClinic = clinicRepository.findById(clinicId);

        // Todo very basic error handling, can be improved by throwing a global exception and intercepting it using
        // Aspects
        if (!optionalClinic.isPresent()) {
            log.error("Clinic is not found for id " + clinicId);
            return new DoctorDTO();
        }

        Clinic clinic = optionalClinic.get();

        Doctor convertedDoctor = doctorMapper.doctorDTOtoDoctor(doctorDTO);

        clinic.addDoctor(convertedDoctor);

        Clinic savedClinic = clinicRepository.save(clinic);

        Optional<Doctor> savedDoctor = savedClinic.getDoctors().stream()
                .filter(doctor -> doctor.getName().equals(doctorDTO.getName()))
                .filter(doctor -> doctor.getPhone().equals(doctorDTO.getPhone()))
                .findFirst();

        if (!savedDoctor.isPresent()) {
            log.error("Coulnd't save doctor !!");
            return new DoctorDTO();
        }

        return doctorMapper.doctorToDoctorDTO(savedDoctor.get());
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .map(doctorMapper::doctorToDoctorDTO)
                .orElseThrow(RuntimeException::new);
    }
}
