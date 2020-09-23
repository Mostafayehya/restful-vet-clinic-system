package com.mostafayehya.restfulvetclinicsystem.services;

import com.mostafayehya.restfulvetclinicsystem.api.dto.VisitDTO;

public interface VisitService {

    VisitDTO createNewVisit(VisitDTO visitDTO);

    VisitDTO getVisitById(Long id);
}
