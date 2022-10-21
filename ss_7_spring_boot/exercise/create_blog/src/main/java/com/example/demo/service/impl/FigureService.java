package com.example.demo.service.impl;

import com.example.demo.model.Figure;
import com.example.demo.repository.IFigureRepository;
import com.example.demo.service.IFigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FigureService implements IFigureService {
    @Autowired
    IFigureRepository iFigureRepository;
    @Override
    public List<Figure> findAll() {
        return iFigureRepository.findAll();
    }

    @Override
    public void save(Figure figure) {
        iFigureRepository.save(figure);
    }

    @Override
    public void remove(Figure figure) {
        iFigureRepository.deleteById(figure.getId());
    }
}
