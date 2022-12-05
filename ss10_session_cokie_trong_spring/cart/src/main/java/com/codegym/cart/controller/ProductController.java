package com.codegym.cart.controller;

import com.codegym.cart.model.Cart;
import com.codegym.cart.model.Product;
import com.codegym.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(Model model, @CookieValue(value = "idProduct",defaultValue = "-1") Long id) {
        if (id!=-1){
            model.addAttribute("historyProduct",productService.findById(id).get());
        }
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }
    @PostMapping("/shopping-cart")
    public  String payToCart(RedirectAttributes redirectAttributes, @SessionAttribute("cart") Cart cart){
        cart.payProduct();
        redirectAttributes.addFlashAttribute("mess","thanh toán thành công");
        return "redirect:/shopping-cart";
    }
    @GetMapping("/decrease/{id}")
    public String decreaseToCart(@PathVariable Long id, @SessionAttribute("cart") Cart cart) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error.404";
        }
        cart.decreaseProduct(product.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping("/detail/{id}")
    public String decreaseToCart(@PathVariable("id") Long id, HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("idProduct", String.valueOf(id));
        cookie.setMaxAge(30);
        cookie.setPath("/");
        response.addCookie(cookie);
        model.addAttribute("product", productService.findById(id).get());
        return "/detail";
    }
}