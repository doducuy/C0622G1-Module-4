package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import com.example.demo.service.ICustomerTypeService;
import com.example.demo.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    ICustomerService icustomerService;
    @Autowired
    ICustomerTypeService iCustomerTypeService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model,
                           @RequestParam(value = "name", defaultValue = "") String name,
                           @RequestParam(value = "email", defaultValue = "") String email,
                           @RequestParam(value = "nameType", defaultValue = "") String nameType) {
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("nameType", nameType);
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customerList", icustomerService.showList(name, email, nameType, pageable));
        return "viewCustomer/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "/viewCustomer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute(value = "customer") Customer customer, Model model, RedirectAttributes redirectAttributes) {
        icustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Add New Customer Success!!!");
        return "redirect:/customer/create";
    }

    @GetMapping("/{id}/edit")
    public String formEdit(@PathVariable int id, Model model) {
        Customer customer = icustomerService.findById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "/viewCustomer/edit";
    }

    @PostMapping("/saveEdit")
    public String saveEdit(@ModelAttribute(value = "customer") Customer customer,RedirectAttributes redirectAttributes) {
        icustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "Edit Customer Success!!!");
        return "redirect:/customer/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(value = "delete") int id, RedirectAttributes redirectAttributes){
        icustomerService.deleteById(id);
        redirectAttributes.addFlashAttribute("messDelete","Delete Success!!!");
        return "redirect:/customer/list";
    }
}
