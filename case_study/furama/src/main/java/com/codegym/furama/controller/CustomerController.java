package com.codegym.furama.controller;

import com.codegym.furama.dto.CustomerDto;
import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.model.customer.CustomerType;
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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;
    @ModelAttribute("customerTypeList")
    public List<CustomerType> getList(){
        return (List<CustomerType>) iCustomerTypeService.findAll();
    }
    @GetMapping("")
    public String showList(CustomerDto customerDto,@RequestParam( value = "name",defaultValue = "")String name
            ,@RequestParam( value = "email",defaultValue = "")String email
            ,@RequestParam( value = "nameType",defaultValue = "")String nameType
            , Model model,@PageableDefault(page = 0,value = 5) Pageable pageable) {
        model.addAttribute("name",name);
        model.addAttribute("email",email);
        model.addAttribute("nameType",nameType);
        model.addAttribute("customerList", iCustomerService.searchAndShowList(name,email,nameType,pageable));
//        model.addAttribute("customer",iCustomerService.findById());

//        CustomerDto customerDto = new CustomerDto();

        model.addAttribute("customerDto",customerDto);
        return "/customer/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("customerDto") CustomerDto customerDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("modalCreate",true);
            return ("redirect:/customer");
        }
        Customer customer= new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("messages", "th??m m???i th??nh c??ng");
        return ("redirect:/customer");
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("deleteById") int id, RedirectAttributes redirectAttributes) {
        iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("messages", "x??a th??nh c??ng");
        return "redirect:/customer";
    }
//    @GetMapping("/update")
//    public String showUpdate(@RequestParam("id") int id , Model model){
//        Optional<Customer> customer = iCustomerService.findById(id);
//        CustomerDto customerDto = new CustomerDto();
//        BeanUtils.copyProperties(customer.get(),customerDto);
//        model.addAttribute("customerDto",customerDto);
//
//        return "/customer/update";
//    }
    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("customerDto") CustomerDto customerDto ,BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("modalUpdate",true);
//redirectAttributes.addFlashAttribute("messages","vui l??ng nh???p ????ng");
            return "redirect:/customer";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("messages","update th??nh c??ng");
        return "redirect:/customer";
    }

}
