package com.codegym.controller;

import com.codegym.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/convert")

public class ConvertController {
@Autowired
 private IConvertService iConvertService;
    @GetMapping("")
    public String convert(){
        return "/index";
    }
    @PostMapping("/add")
    public  String convent(@RequestParam(defaultValue = "0") double usd , @RequestParam(defaultValue = "0") double vnd , Model model){
        double kq1 = iConvertService.convertusd(vnd);
        double kq2 = iConvertService.convertvnd(usd);
        model.addAttribute("kq1",kq1);
        model.addAttribute("kq2",kq2);
        return "/index";
    }
}
