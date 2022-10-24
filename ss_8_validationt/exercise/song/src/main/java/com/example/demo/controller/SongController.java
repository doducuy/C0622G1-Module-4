package com.example.demo.controller;

import com.example.demo.model.Song;
import com.example.demo.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("song",new Song());
        return "/create";
    }
}
