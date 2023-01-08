package com.codegym.cinema.controller;

import com.codegym.cinema.model.ShowTimeCinema;
import com.codegym.cinema.service.IMovieService;
import com.codegym.cinema.service.IShowTimeCinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("")
public class ShowTimeCinemaController {
    private IShowTimeCinemaService iShowTimeCinemaService;
    private IMovieService iMovieService;
@Autowired
    public ShowTimeCinemaController(IShowTimeCinemaService iShowTimeCinemaService, IMovieService iMovieService) {
        this.iShowTimeCinemaService = iShowTimeCinemaService;
        this.iMovieService = iMovieService;
    }
    @GetMapping("")
    public String showList(Model model){
    model.addAttribute("showTimeCinemaList",iShowTimeCinemaService.findAllStatusOne());
    return "/list";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("deleteByCinemaCode") String deleteByCinemaCode , RedirectAttributes redirectAttributes){
    iShowTimeCinemaService.delete(deleteByCinemaCode);
    redirectAttributes.addFlashAttribute("messages","xóa thành công");
    return "redirect:/movie";
    }

    @PostMapping("/add")
    public String addClass(@Valid @ModelAttribute("showTimeCinema") ShowTimeCinema showTimeCinema, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("createModal", true);
            return "list";
        }
            iShowTimeCinemaService.save(showTimeCinema);

        return "redirect:/list";
    }




}
