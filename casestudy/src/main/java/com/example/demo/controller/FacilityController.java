package com.example.demo.controller;

import com.example.demo.model.Facility;
import com.example.demo.service.IFacilityService;
import com.example.demo.service.IFacilityTypeService;
import com.example.demo.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    IFacilityService iFacilityService;
    @Autowired
    IFacilityTypeService iFacilityTypeService;
    @Autowired
    IRentTypeService iRentTypeService;

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 2) Pageable pageable, Model model,
                           @RequestParam(value = "name", defaultValue = "") String name,
                           @RequestParam(value = "nameType", defaultValue = "") String nameType) {
        model.addAttribute("name",name);
        model.addAttribute("nameType",nameType);
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("facilityList", iFacilityService.showList(name, nameType, pageable));
        return "Facility/list";
    }
    @GetMapping("/create/villa")
    public String formCreateVilla(Model model){
        model.addAttribute("facility",new Facility());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList",iRentTypeService.findAll());
        return "Facility/createVilla";
    }
    @GetMapping("/create/room")
    public String formCreateRoom(Model model){
        model.addAttribute("facility",new Facility());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList",iRentTypeService.findAll());
        return "Facility/createRoom";
    }
    @GetMapping("/create/house")
    public String formCreateHouse(Model model){
        model.addAttribute("facility",new Facility());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList",iRentTypeService.findAll());
        return "Facility/createHouse";
    }
    @PostMapping("/save/villa")
    public String save(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes){
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Create New Facility Success!!!");
        return  "redirect:/facility/create/villa";
    }
    @PostMapping("/save/House")
    public String saveHouse(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes){
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Create New Facility Success!!!");
        return  "redirect:/facility/create/house";
    }
    @PostMapping("/save/room")
    public String saveRoom(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes){
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess","Create New Facility Success!!!");
        return  "redirect:/facility/create/room";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(value = "delete") int id, RedirectAttributes redirectAttributes){
        iFacilityService.deleteById(id);
        redirectAttributes.addFlashAttribute("messDelete","Delete Success!!!");
        return "redirect:/facility/list";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable int id, Model model) {
        Facility facility = iFacilityService.findById(id);
            model.addAttribute("facility", facility);
            model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
            model.addAttribute("rentTypeList", iRentTypeService.findAll());
            return "Facility/edit";
    }
    @PostMapping("/saveEdit")
    public String saveEdit(@ModelAttribute(value = "facility") Facility facility,RedirectAttributes redirectAttributes) {
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("mess", "Edit Facility Success!!!");
        return "redirect:/facility/list";
    }
}
