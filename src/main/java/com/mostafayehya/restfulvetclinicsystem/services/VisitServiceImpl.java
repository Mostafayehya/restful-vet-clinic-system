package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.VisitDTO;
import com.mostafayehya.restfulvetclinicsystem.api.mapper.VisitMapper;
import com.mostafayehya.restfulvetclinicsystem.domain.Visit;
import com.mostafayehya.restfulvetclinicsystem.repositories.VisitRepository;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final VisitMapper visitMapper;

    public VisitServiceImpl(VisitRepository visitRepository, VisitMapper visitMapper) {
        this.visitRepository = visitRepository;
        this.visitMapper = visitMapper;
    }

    @Override
    public VisitDTO createNewVisit(VisitDTO visitDTO) {
        Visit visit = visitMapper.visitDTOtoVisit(visitDTO);
        return visitMapper.visitToVisitDTO(visitRepository.save(visit));
    }

    @Override
    public VisitDTO getVisitById(Long id) {
        return visitRepository.findById(id)
                .map(visitMapper::visitToVisitDTO)
                .orElseThrow(RuntimeException::new);
    }
}
