package com.example.demo.service.impl;

import com.example.demo.model.Facility;
import com.example.demo.repository.IFacilityRepository;
import com.example.demo.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> showList(String name, String nameType, Pageable pageable) {
        return iFacilityRepository.findByName(name,nameType, pageable);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }
}
