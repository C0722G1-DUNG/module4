package com.computer.controller.controller;

import com.computer.controller.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class ComputerController {
    @Autowired
    private IComputerService iComputerService;

    @GetMapping()
    public String string() {
        return "/index";
    }

    @PostMapping("/computer")
    public String computer(double numberOne, double numberTwo, String chose , Model model) {
 double result;
 try {
     result =  iComputerService.calculate(numberOne,numberTwo,chose);
     model.addAttribute("result",result);
 }catch (ArithmeticException e){
     model.addAttribute("result",e.getMessage());
 }


//        double result1 = iComputerService.addition(numberOne, numberTwo);
//        double result2 = iComputerService.subtraction(numberOne, numberTwo);
//        double result3 = iComputerService.multiplication(numberOne, numberTwo);
//        double result4 = iComputerService.division(numberOne, numberTwo);
//        model.addAttribute("result1",result1);
//        model.addAttribute("result2",result2);
//        model.addAttribute("result3",result3);
//        model.addAttribute("result4",result4);
        return "/index";
    }
}
