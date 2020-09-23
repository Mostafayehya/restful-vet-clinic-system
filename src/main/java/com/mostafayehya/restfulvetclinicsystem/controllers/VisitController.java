package com.mostafayehya.restfulvetclinicsystem.controllers;

import com.mostafayehya.restfulvetclinicsystem.api.dto.VisitDTO;
import com.mostafayehya.restfulvetclinicsystem.services.VisitService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class VisitController {

    private VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;

    }

    @PostMapping("/api/visits")
    @ResponseStatus(HttpStatus.CREATED)
    public VisitDTO createVisit(@RequestBody VisitDTO visitDTO) {
        return visitService.createNewVisit(visitDTO);
    }

    @GetMapping("/api/visits/{id}")
    @ResponseStatus(HttpStatus.OK)
    public VisitDTO getVisitById(@PathVariable Long id){
        return visitService.getVisitById(id);
    }
}
