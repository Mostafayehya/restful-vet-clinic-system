package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.ClinicDTO;
import com.mostafayehya.restfulvetclinicsystem.api.dto.DoctorDTO;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.ClinicMapper;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.DoctorMapper;
import com.mostafayehya.restfulvetclinicsystem.domain.Clinic;
import com.mostafayehya.restfulvetclinicsystem.repositories.ClinicRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClinicServiceImpl implements ClinicService {

    private ClinicRepository clinicRepository;
    private ClinicMapper clinicMapper;
    private DoctorMapper doctorMapper;

    public ClinicServiceImpl(ClinicRepository clinicRepository, ClinicMapper clinicMapper, DoctorMapper doctorMapper) {
        this.clinicRepository = clinicRepository;
        this.clinicMapper = clinicMapper;
        this.doctorMapper = doctorMapper;
    }


    @Override
    public List<DoctorDTO> getAllDoctors(Long clinicId) {
        Optional<Clinic> optionalClinic = clinicRepository.findById(clinicId);

        if (!optionalClinic.isPresent()) {
            log.error("can't find clinic with id " + clinicId);
            return new ArrayList<>();
        }
        Clinic clinic = optionalClinic.get();
        return clinic.getDoctors().stream()
                .map(doctorMapper::doctorToDoctorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClinicDTO findByPhoneOrAddress(String phone, String address) {
        Optional<Clinic> optionalClinic = clinicRepository.findByPhoneOrAddress(phone, address);

        if (!optionalClinic.isPresent()) {
            log.error("Can't find clinic with phone " + phone + " or address " + address);
            return new ClinicDTO();
        }
        return clinicMapper.clinicToClinicDTO(optionalClinic.get());
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
