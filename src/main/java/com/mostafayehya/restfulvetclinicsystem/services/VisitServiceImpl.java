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

    public VisitServiceImpl(VisitRepository visitRepository, VisitMapper visitMapper, PetMapper petMapper, DoctorMapper doctorMapper, ClinicMapper clinicMapper) {
        this.visitRepository = visitRepository;
        this.visitMapper = visitMapper;
        this.petMapper = petMapper;
        this.doctorMapper = doctorMapper;
        this.clinicMapper = clinicMapper;
    }

    @Override
    @Transactional
    public VisitDTO createNewVisit(VisitDTO visitDTO) {

        Visit visit = visitMapper.visitDTOtoVisit(visitDTO);
        Pet pet = petMapper.PetDTOtoPet(visitDTO.getPetDTO());
        Doctor doctor = doctorMapper.doctorDTOtoDoctor(visitDTO.getDoctorDTO());
        Clinic clinic = clinicMapper.clinicDTOtoClinic(visitDTO.getClinicDTO());

        // Binding entities
        visit.setPet(pet);

        visit.setClinic(clinic);
        doctor.setClinic(clinic);
        visit.setDoctor(doctor);

        clinic = clinic.addDoctor(doctor);
        visit.setClinic(clinic);

        return visitMapper.visitToVisitDTO(visitRepository.save(visit));
    }

    @Override
    public VisitDTO getVisitById(Long id) {
        return visitRepository.findById(id)
                .map(visitMapper::visitToVisitDTO)
                .orElseThrow(RuntimeException::new);
    }
}
