package com.codegym.validate.controller;
import com.codegym.validate.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping("/user")
@Controller
public class UserController {
    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "/index";
    }

    @PostMapping("/validateUser")
    public String checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return"/index";
        }
        return"/result";
    }
}
