package com.example.demo.controller;

import com.example.demo.model.Song;
import com.example.demo.model.SongDto;
import com.example.demo.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    ISongService iSongService;
    @GetMapping("/list")
    public String showList(@PageableDefault (value = 1) Pageable pageable, Model model){
        model.addAttribute("songList",iSongService.findAll(pageable));
        return "/list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("songDto",new SongDto());
        return "/create";
    }
    @PostMapping("saveSong")
    public String saveUser(@Validated @ModelAttribute(value = "songDto") SongDto songDto, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "/create";
        }else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            iSongService.saveSong(song);
            redirectAttributes.addFlashAttribute("mess", "Add Success!!!");
            return "redirect:/list";
        }
    }
}
