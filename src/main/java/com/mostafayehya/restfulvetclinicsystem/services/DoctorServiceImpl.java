package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.DoctorDTO;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.DoctorMapper;
import com.mostafayehya.restfulvetclinicsystem.domain.Clinic;
import com.mostafayehya.restfulvetclinicsystem.domain.Doctor;
import com.mostafayehya.restfulvetclinicsystem.repositories.ClinicRepository;
import com.mostafayehya.restfulvetclinicsystem.repositories.DoctorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
    @Transactional
    public DoctorDTO assignDoctorToClinic(Long clinicId, DoctorDTO doctorDTO) {

        Optional<Clinic> optionalClinic = clinicRepository.findById(clinicId);

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
    @Transactional
    public void deassignDoctorToClinic(Long clinicId, DoctorDTO doctorDTO) {

        Optional<Clinic> optionalClinic = clinicRepository.findById(clinicId);

        if (!optionalClinic.isPresent()) {
            log.error("Clinic is not found for id " + clinicId);
            return;
        }

        Clinic clinic = optionalClinic.get();

        Doctor detachedDoctor = doctorMapper.doctorDTOtoDoctor(doctorDTO);
        detachedDoctor.setClinic(null);

        Set<Doctor> newSet = clinic.getDoctors()
                .stream()
                .filter(doctor -> !doctor.getId().equals(doctorDTO.getId()))
                .collect(Collectors.toSet());

        clinic.setDoctors(newSet);

        clinicRepository.save(clinic);
        doctorRepository.save(detachedDoctor);

    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .map(doctorMapper::doctorToDoctorDTO)
                .orElseThrow(RuntimeException::new);
    }
}
