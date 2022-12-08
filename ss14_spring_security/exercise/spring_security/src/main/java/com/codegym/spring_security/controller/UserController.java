package com.codegym.spring_security.controller;

import com.codegym.spring_security.model.User;
import com.codegym.spring_security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;
    @GetMapping("")
    public String showList(Model model, Pageable pageable) {
        model.addAttribute("userList",iUserService.findAll(pageable));
        return "/list";
    }
    @GetMapping("/update")
    public String showUpdate(Model model,@RequestParam("id")Integer id){
        model.addAttribute("user",iUserService.findById(id).get());
        return "/update";
    }
    @PostMapping("/update")
    public String update(RedirectAttributes redirectAttributes,@ModelAttribute("user")User user){
       iUserService.save(user);
       redirectAttributes.addFlashAttribute("mess","cập nhật thành công");
        return "redirect:/user";
    }
}
