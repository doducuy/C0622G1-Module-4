package com.example.demo.controller;

import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import com.example.demo.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService icustomerService;
    @Autowired
    ICustomerTypeService iCustomerTypeService;
    @GetMapping("/list")
    public String showList(@PageableDefault(value = 2) Pageable pageable, Model model,
                           @RequestParam(value = "name",defaultValue ="" ) String name,
                           @RequestParam(value = "email", defaultValue = "") String email,
                           @RequestParam(value = "nameType", defaultValue = "") String nameType){
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customerList",icustomerService.showList(name,email,nameType,pageable));
        return "viewCustomer/list";
    }
}
