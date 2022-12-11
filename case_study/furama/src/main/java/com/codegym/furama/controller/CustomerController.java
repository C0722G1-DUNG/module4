package com.codegym.furama.controller;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.service.ICustomerService;
import com.codegym.furama.service.ICustomerTypeService;
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

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;
    @GetMapping("")
    public String showList(@RequestParam( value = "name",defaultValue = "")String name
            ,@RequestParam( value = "email",defaultValue = "")String email
            ,@RequestParam( value = "nameType",defaultValue = "")String nameType
            , Model model,@PageableDefault(page = 0,value = 5) Pageable pageable) {
        model.addAttribute("customerList", iCustomerService.searchAndShowList(name,email,nameType,pageable));
        return "/customer/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
       model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("customerDto") CustomerDto customerDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return ("customer/create");
        }
        Customer customer= new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("messages", "thêm mới thành công");
        return ("redirect:/customer/create");
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteById") int id, RedirectAttributes redirectAttributes) {
        iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("messages", "xóa thành công");
        return "redirect:/customer";
    }
    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id , Model model){
        Optional<Customer> customer = iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(),customerDto);
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customerDto",customerDto);

        return "/customer/update";
    }
    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("customerDto") CustomerDto customerDto ,BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());

            return "/customer/update";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("messages","update thành công");
        return "redirect:/customer";
    }

}
