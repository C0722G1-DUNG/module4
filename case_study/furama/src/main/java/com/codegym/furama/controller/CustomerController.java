package com.codegym.furama.controller;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    public String showList(@RequestParam( value = "name",defaultValue = "")String name,@RequestParam( value = "email",defaultValue = "")String email,@RequestParam( value = "nameType",defaultValue = "")String nameType, Model model,@PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("customerList", iCustomerService.searchAndShowList(name,email,nameType,pageable));
        return "customer/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("customerDto") CustomerDto customerDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {

            return ("customer/create");
        }
        Customer customer= new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("mess", "thêm mới thành công");
        return ("redirect:/customer/create");
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteById") int id, RedirectAttributes redirectAttributes) {
        iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("mess", "xóa thành công");
        return "redirect:/customer";
    }
    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id , Model model){
        model.addAttribute("customer",iCustomerService.findById(id));

        return "/customer/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("customer") Customer customer , RedirectAttributes redirectAttributes){
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("messages","update thành công");
        return "redirect:/customer";
    }

}
