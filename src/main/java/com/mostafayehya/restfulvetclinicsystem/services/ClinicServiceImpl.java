package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.ClinicDTO;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.ClinicMapper;
import com.mostafayehya.restfulvetclinicsystem.domain.Clinic;
import com.mostafayehya.restfulvetclinicsystem.repositories.ClinicRepository;
import org.springframework.stereotype.Service;

@Service
public class ClinicServiceImpl implements ClinicService {

    private ClinicRepository clinicRepository;
    private ClinicMapper clinicMapper;

    public ClinicServiceImpl(ClinicRepository clinicRepository, ClinicMapper clinicMapper) {
        this.clinicRepository = clinicRepository;
        this.clinicMapper = clinicMapper;
    }

    @Override
    public ClinicDTO createNewClinic(ClinicDTO clinicDTO) {
        Clinic clinic = clinicMapper.clinicDTOtoClinic(clinicDTO);
        ClinicDTO saveClinicDTO = clinicMapper.clinicToClinicDTO(clinicRepository.save(clinic));
        return saveClinicDTO;
    }

    @Override
    public ClinicDTO getClinicById(Long id) {
        return clinicRepository.findById(id)
                .map(clinicMapper::clinicToClinicDTO)
                .orElseThrow(RuntimeException::new);
    }
}
