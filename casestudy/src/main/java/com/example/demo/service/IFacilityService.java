package com.example.demo.service;

import com.example.demo.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> showList(String name, String nameType, Pageable pageable);
    void save(Facility facility);
}
