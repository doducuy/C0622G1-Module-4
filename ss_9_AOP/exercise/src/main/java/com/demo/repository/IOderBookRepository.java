package com.demo.repository;

import com.demo.model.OderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOderBookRepository extends JpaRepository<OderBook,Integer> {
}
