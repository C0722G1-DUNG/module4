package com.example.demo.controller;

import com.example.demo.service.IMovieService;
import com.example.demo.service.IShowTimeCinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/movie")
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

}
