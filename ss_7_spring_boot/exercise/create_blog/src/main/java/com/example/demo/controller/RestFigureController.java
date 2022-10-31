package com.example.demo.controller;

import com.example.demo.dto.FigureDto;
import com.example.demo.model.Figure;
import com.example.demo.service.impl.FigureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/figure/v1")
public class RestFigureController {
    @Autowired
    private FigureService figureService;

    @GetMapping
    public ResponseEntity<List<Figure>> getFigureList() {
        List<Figure> figureList = figureService.findAll();
        if (figureList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(figureList, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Void> addFigure(@RequestBody FigureDto figureDto) {
        Figure figure = new Figure();
        BeanUtils.copyProperties(figureDto, figure);
        figureService.save(figure);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Figure> updateFigure(@PathVariable int id, @RequestBody FigureDto figureDto){
        Figure currentFigure = figureService.findById(id);
        if(currentFigure ==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        figureDto.setId(id);
        BeanUtils.copyProperties(figureDto,currentFigure);
        figureService.save(currentFigure);
        return new ResponseEntity<>(currentFigure,HttpStatus.OK);
    }
}
