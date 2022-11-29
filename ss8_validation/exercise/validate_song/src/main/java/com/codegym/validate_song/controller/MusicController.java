package com.codegym.validate_song.controller;

import com.codegym.validate_song.model.Music;
import com.codegym.validate_song.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/music")
@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("musicList", iMusicService.findAll());
        return "/index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("music") Music music, BindingResult bindingResult , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {

            return ("/create");
        }
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("mess","thêm mới thành công");
        return ("redirect:/music/create");
    }
    @GetMapping("/update")
    public String ShowFormUpdate(@RequestParam("id") int id, Model model){
        model.addAttribute("music",iMusicService.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("music") Music music ,BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()){
            return "/update";
        }
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("messages","update thành công");
        return "redirect:/music";
    }

}
