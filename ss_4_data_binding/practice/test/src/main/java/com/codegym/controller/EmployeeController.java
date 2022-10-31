package com.codegym.controller;

import com.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @GetMapping("/showForm")
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }
    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute(value = "employee") Employee employee, ModelMap model){
        model.addAttribute("id",employee.getId());
        model.addAttribute("name",employee.getName());
        model.addAttribute("contactNumber",employee.getContactNumber());
        return "employee/info";
    }
}
