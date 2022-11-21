package com.example.controller;

import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;
    @GetMapping()
    public String string(){
        return "/index";
    }
    @PostMapping("/dictionary")
    public String dictionary(String dictionary, Model model){
        String result = dictionaryService.search(dictionary);
        model.addAttribute("result",result);
        return "/index";
    }
}
