package com.example.demo.repository;

import com.example.demo.model.Figure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFigureRepository extends JpaRepository<Figure,Integer> {

}
