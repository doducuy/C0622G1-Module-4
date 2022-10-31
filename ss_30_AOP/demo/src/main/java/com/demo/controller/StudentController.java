package com.demo.controller;

import com.demo.dto.StudentDTO;
import com.demo.model.Student;
import com.demo.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping()
public class StudentController {
    @Autowired
    IStudentService iStudentService;

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("students", iStudentService.findAll());
        return "/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable(value = "id") int id, Model model) {
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(iStudentService.findById(id),studentDTO);
        model.addAttribute("studentdto",studentDTO);
        return "/edit";
    }

    @PostMapping("/saveEdit")
    public String saveEdit(@Valid @ModelAttribute(value = "studentdto") StudentDTO studentDto,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new StudentDTO().validate(studentDto, bindingResult);
        if(bindingResult.hasErrors()){
            return "/edit";
        }else {
            Student student =new Student();
            BeanUtils.copyProperties(studentDto,student);
            iStudentService.save(student);
            redirectAttributes.addFlashAttribute("mess", "edit success!!!");
            return "redirect:/list";
        }

    }
}
