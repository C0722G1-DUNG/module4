package com.codegym.demo.controller;

import com.codegym.demo.model.Customer;
import com.codegym.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @GetMapping("")
    public String listCustomers(Model model) {

        model.addAttribute("customers", customerService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {

         customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "THêm mới thành công");
        return "redirect:/customer/create";
    }

}