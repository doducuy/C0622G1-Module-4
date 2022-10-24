package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserDto;
import com.example.demo.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    IUserService iUserService;
    @GetMapping("/list")
    public String showList(@PageableDefault (value = 1)Pageable pageable, Model model){
        model.addAttribute("userList",iUserService.findAll(pageable));
        return "/list";
    }
    @GetMapping("/createUser")
    public String showCreateForm(Model model){
        model.addAttribute("user",new UserDto());
        return "/create";
    }
    @PostMapping("/saveUser")
    public String saveUser(@Validated  @ModelAttribute(value = "user") UserDto userdto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        new UserDto().validate(userdto,bindingResult);
        if(bindingResult.hasErrors()){
            return "/create";
        }else {
            User user = new User();
            BeanUtils.copyProperties(userdto,user);
            iUserService.saveUser(user);
            redirectAttributes.addFlashAttribute("mess", "Add Success!!!");
            return "redirect:/list";
        }

    }
    @GetMapping("/{id}/editUser")
    public String showEditForm(@PathVariable int id, Model model){
        model.addAttribute("user", iUserService.findById(id));
        return "/edit";
    }
    @PostMapping("/saveEditUser")
    public String saveEditUser(@ModelAttribute User user, RedirectAttributes redirectAttributes){
        iUserService.saveUser(user);
        redirectAttributes.addFlashAttribute("mess", "Edit Success!!!");
        return "redirect:/list";
    }
}
