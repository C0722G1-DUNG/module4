package com.codegym.validate_song.controller;

import com.codegym.validate_song.dto.MusicDto;
import com.codegym.validate_song.model.Music;
import com.codegym.validate_song.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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
        model.addAttribute("musicDto", new MusicDto());
        return "/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("musicDto") MusicDto musicDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {

            return ("/create");
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return ("redirect:/music/create");
    }

    @GetMapping("/update")
    public String ShowFormUpdate(@RequestParam("id") int id, Model model) {
        Optional<Music> music = iMusicService.findById(id);
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music.get(), musicDto);
        model.addAttribute("musicDto", musicDto);
        return "/update";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("musicDto") MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/update";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        iMusicService.save(music);
        redirectAttributes.addFlashAttribute("messages", "update thành công");
        return "redirect:/music";
    }

}
