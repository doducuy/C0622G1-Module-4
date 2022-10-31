package com.example.demo.service.impl;

import com.example.demo.model.Figure;
import com.example.demo.repository.IFigureRepository;
import com.example.demo.service.IFigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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



    @Override
    public Figure findById(int id) {
        Figure figure = iFigureRepository.findById(id).orElse(null);
        return figure;
    }

    @Override
    public Page<Figure> findAll(Pageable pageable) {
        return iFigureRepository.findAll(pageable);
    }
}
