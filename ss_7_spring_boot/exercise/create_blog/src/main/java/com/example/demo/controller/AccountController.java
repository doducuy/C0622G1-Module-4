package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.repository.IAccountRepository;
import com.example.demo.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/home")
public class AccountController {
    @Autowired
    IAccountService iAccountService;
    @GetMapping("/listAccount")
    public String showListAccount(Model model){
        model.addAttribute("accountList",iAccountService.findAll());
        return "/account/list";
    }
    @GetMapping("/createAccount")
    public String showCreateAccountForm(Model model){
        model.addAttribute("account",new Account());
        return "/account/create";
    }
    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute (value = "account") Account account, RedirectAttributes redirectAttributes){
        iAccountService.saveAccount(account);
        redirectAttributes.addFlashAttribute("mess", "Add Success!!!");
        return "redirect:/home/listAccount";
    }
    @GetMapping("/{id}/editAccount")
    public String showEditAccountForm(@PathVariable int id, Model model){
        model.addAttribute("account",iAccountService.findById(id));
        return "/account/edit";
    }
    @PostMapping("/saveEditAccount")
    public String saveEditAccount(@ModelAttribute Account account, RedirectAttributes redirectAttributes){
        iAccountService.saveAccount(account);
        redirectAttributes.addFlashAttribute("mess","Edit Success!!!");
        return "redirect:/home/listAccount";
    }
    @GetMapping("/{id}/deleteAccount")
    public String deleteAccount( @ModelAttribute (value = "account") Account account, RedirectAttributes redirectAttributes){
        iAccountService.deleteAccount(account);
        redirectAttributes.addFlashAttribute("mess", "Delete Success!!!");
        return "redirect:/home/listAccount";
    }
}
