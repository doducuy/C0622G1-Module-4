package com.example.demo.controller;

import com.example.demo.model.Contract;
import com.example.demo.model.Employee;
import com.example.demo.service.IContractService;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.IEmployeeService;
import com.example.demo.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService iContractService;
    @Autowired
    ICustomerService iCustomerService;
    @Autowired
    IFacilityService iFacilityService;
    @Autowired
    IEmployeeService iEmployeeService;

    @GetMapping("/create")
    public String formCreate(Model model){
        model.addAttribute("contract", new Contract());
        List<Employee> employeeList = iEmployeeService.findAll();
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("customerList",iCustomerService.findAll());
        model.addAttribute("facilityList",iFacilityService.findAll());
        return "/viewContract/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes){
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("mess","Create New Contract Success!!!");
        return "redirect:/contract/create";
    }
}
