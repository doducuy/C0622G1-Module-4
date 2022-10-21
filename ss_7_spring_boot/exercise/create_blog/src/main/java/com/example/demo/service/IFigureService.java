package com.example.demo.service;

import com.example.demo.model.Figure;

import java.util.List;

public interface IFigureService {
    List<Figure> findAll();
    void save(Figure figure);
    void remove(Figure figure);
}
