package com.codegym.controller;

import com.codegym.model.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class ConfigurationController {
    @GetMapping
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("formStore","configuration",new Configuration());
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Configuration configuration ){
        ModelAndView modelAndView = new ModelAndView("update","configuration",configuration);
        modelAndView.addObject("mess","Update Success!");
        return modelAndView;
    }
}
