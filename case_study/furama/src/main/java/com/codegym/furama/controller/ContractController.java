package com.codegym.furama.controller;

import com.codegym.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("contractList",iContractService.listContract());
        return "/contract/list";
    }

}
