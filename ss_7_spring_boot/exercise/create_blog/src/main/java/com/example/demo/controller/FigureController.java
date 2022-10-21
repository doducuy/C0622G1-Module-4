package com.example.demo.controller;

import com.example.demo.model.Figure;
import com.example.demo.repository.IFigureRepository;
import com.example.demo.service.IFigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
public class FigureController {
    @Autowired
    IFigureService iFigureService;
    @GetMapping
    public String home(){
        return "home";
    }
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("figureList",iFigureService.findAll());
        return "figure/list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("figure",new Figure());
        return "figure/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute (value = "figure") Figure figure, RedirectAttributes redirectAttributes){
        iFigureService.save(figure);
        redirectAttributes.addFlashAttribute("mess", "add success");
        return "redirect:/home/list";
    }
    @GetMapping("/{id}/delete")
    public String delete(@ModelAttribute (value = "figure")Figure figure, RedirectAttributes redirectAttributes){
        iFigureService.remove(figure);
        redirectAttributes.addFlashAttribute("mess", "delete success");
        return "redirect:/home/list";
    }
}
