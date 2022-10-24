package com.example.demo.service;

import com.example.demo.model.Figure;

import java.util.List;
import java.util.Optional;

public interface IFigureService {
    List<Figure> findAll();
    void save(Figure figure);
    void remove(Figure figure);
    Figure findById(int id);
}
