package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;
    @GetMapping("")
    public String finAll(@RequestParam(defaultValue = "", required = false) String nameProduct, Model model){
        List<Product> productList = iProductService.findAllAndSearch(nameProduct);
        model.addAttribute("productList",productList);

        return "/index";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("deleteById") int deleteById , RedirectAttributes redirectAttributes){
        String messages = "xoa thanh cong";
        iProductService.Delete(deleteById);
        redirectAttributes.addFlashAttribute("messages",messages);
        return "redirect:/product";
    }
    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") int id ,Model model){
        Product product = iProductService.findById(id);
        model.addAttribute("product",product);
        return "/update";
    }
    @PostMapping("/update")
    public String update(Product product , RedirectAttributes redirectAttributes){
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("messages","update thanh cong");
        return "redirect:/product";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("product",new Product());
        return "/create";
    }
    @PostMapping("/create")
    public String create(Product product, RedirectAttributes redirectAttributes){
        iProductService.create(product);
        redirectAttributes.addFlashAttribute("messages","thêm mới thành công");
        return "redirect:/product/create";
    }
}
