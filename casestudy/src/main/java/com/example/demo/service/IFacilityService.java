package com.example.demo.service;

import com.example.demo.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> showList(String name, String nameType, Pageable pageable);
    void save(Facility facility);
    void deleteById(int id);
    Facility findById(int id);
    List<Facility> findAll();
}
