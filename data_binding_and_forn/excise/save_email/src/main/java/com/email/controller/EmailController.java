package com.email.controller;

import com.email.model.Email;
import com.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
//@RequestMapping("email")
public class EmailController {
    @Autowired
    private IEmailService iEmailService;

    @GetMapping()
    public String listEmail(Model model) {
        List<Email> emailList = iEmailService.findAll();
        model.addAttribute("emailList", emailList);
        return "email/list";
    }

    @GetMapping("/update")
    public String showEdit(@RequestParam("id") int id ,Model model){
        Email email = iEmailService.findById(id);
        List<String> languagesList = Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
        List<Integer> pageSizeList = Arrays.asList(5,10,15,20,25);
         model.addAttribute("email",email);
         model.addAttribute("languagesList",languagesList);
         model.addAttribute("pageSizeList",pageSizeList);
        return "email/edit";
    }
    @PostMapping("update")
    public String edit(Email email , RedirectAttributes redirectAttributes){
        iEmailService.update(email);
        redirectAttributes.addFlashAttribute("mess","cập nhật thành công");
        return "redirect:email/list";
    }

}
