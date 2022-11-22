package com.sandwich.controller;

import com.sandwich.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Controller
public class SandwichController  {
    @Autowired
    private ISandwichService iSandwichService ;
    @GetMapping()
    public String string(){
   return "/index";
    }
    @PostMapping("/sandwich")
    public String sandwich(Model model , @RequestParam("choise") String choise){
       List<String> result =  iSandwichService.choise(choise);
       model.addAttribute("result",result);
        return "/index";
    }


}
