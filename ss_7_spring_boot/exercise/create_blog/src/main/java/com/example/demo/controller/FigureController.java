package com.example.demo.controller;

import com.example.demo.model.Figure;
import com.example.demo.repository.IFigureRepository;
import com.example.demo.service.IAccountService;
import com.example.demo.service.IFigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/home")
public class FigureController {
    @Autowired
    IFigureService iFigureService;
    @Autowired
    IAccountService iAccountService;

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 1) Pageable pageable, Model model) {
        model.addAttribute("figureList", iFigureService.findAll(pageable));
        model.addAttribute("accounts",iAccountService.findAll());
        return "figure/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("figure", new Figure());
        return "figure/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(value = "figure") Figure figure, RedirectAttributes redirectAttributes) {
        iFigureService.save(figure);
        redirectAttributes.addFlashAttribute("mess", "add success");
        return "redirect:/home/list";
    }

    @GetMapping("/{id}/delete")
    public String delete( Figure figure, RedirectAttributes redirectAttributes) {
        iFigureService.remove(figure);
        redirectAttributes.addFlashAttribute("mess", "delete success");
        return "redirect:/home/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable (value = "id") Integer id, Model model) {
       Figure figure =iFigureService.findById(id);
        model.addAttribute("figure", figure);
        return "figure/edit";
    }
    @PostMapping("/saveEdit")
    public String saveEdit(RedirectAttributes redirectAttributes , @ModelAttribute (value = "figure") Figure figure){
        iFigureService.save(figure);
        redirectAttributes.addFlashAttribute("mess", "Update Oke!");
        return "redirect:/home/list";
    }
}
