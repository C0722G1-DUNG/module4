package com.codegym.furama.controller;

import com.codegym.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
 @GetMapping("")
    public String showList(Model model , Pageable pageable){
     model.addAttribute("customerList",iCustomerService.findAll(pageable));
     return "/customer/list";
 }
}
