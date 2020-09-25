package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.VisitDTO;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.ClinicMapper;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.DoctorMapper;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.PetMapper;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.VisitMapper;
import com.mostafayehya.restfulvetclinicsystem.domain.Clinic;
import com.mostafayehya.restfulvetclinicsystem.domain.Doctor;
import com.mostafayehya.restfulvetclinicsystem.domain.Pet;
import com.mostafayehya.restfulvetclinicsystem.domain.Visit;
import com.mostafayehya.restfulvetclinicsystem.repositories.ClinicRepository;
import com.mostafayehya.restfulvetclinicsystem.repositories.DoctorRepository;
import com.mostafayehya.restfulvetclinicsystem.repositories.PetRepository;
import com.mostafayehya.restfulvetclinicsystem.repositories.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;
    private final PetMapper petMapper;
    private final DoctorMapper doctorMapper;
    private final ClinicMapper clinicMapper;
    private final ClinicRepository clinicRepository;
    private DoctorRepository doctorRepository;
    private PetRepository petRepository;

    public VisitServiceImpl(VisitRepository visitRepository, VisitMapper visitMapper, PetMapper petMapper, DoctorMapper doctorMapper, ClinicMapper clinicMapper, ClinicRepository clinicRepository, DoctorRepository doctorRepository, PetRepository petRepository) {
        this.visitRepository = visitRepository;
        this.visitMapper = visitMapper;
        this.petMapper = petMapper;
        this.doctorMapper = doctorMapper;
        this.clinicMapper = clinicMapper;
        this.clinicRepository = clinicRepository;
        this.doctorRepository = doctorRepository;
        this.petRepository = petRepository;
    }

    @Override
    @Transactional
    public VisitDTO createNewVisit(VisitDTO visitDTO) {

        Visit visit = visitMapper.visitDTOtoVisit(visitDTO);
        Pet pet = petMapper.PetDTOtoPet(visitDTO.getPet());
        Doctor doctor = doctorMapper.doctorDTOtoDoctor(visitDTO.getDoctor());
        Clinic clinic = clinicMapper.clinicDTOtoClinic(visitDTO.getClinic());

        clinic.addDoctor(doctor);
        clinic = clinicRepository.save(clinic);

        doctor.setClinic(clinic);
        doctor = doctorRepository.save(doctor);

        pet = petRepository.save(pet);

        visit = visit.addClinic(clinic);
        visit = visit.addDoctor(doctor);
        visit.setPet(pet);

        visit = visitRepository.save(visit);
        visitDTO = visitMapper.visitToVisitDTO(visit);

        return visitDTO;
    }

    @Override
    public VisitDTO getVisitById(Long id) {
        return visitRepository.findById(id)
                .map(visitMapper::visitToVisitDTO)
                .orElseThrow(RuntimeException::new);
    }
}
