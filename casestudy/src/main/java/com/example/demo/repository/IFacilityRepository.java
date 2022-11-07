package com.example.demo.repository;

import com.example.demo.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility join facility_type on facility.facility_type_id = facility_type.id where facility.name like %:name% and facility_type.name like %:nameType%", nativeQuery = true)
    Page<Facility> findByName(@Param("name") String name,
                              @Param("nameType") String nameType,
                              Pageable pageable);
}
