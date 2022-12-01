package com.codegym.books.controller;

import com.codegym.books.model.Book;
import com.codegym.books.model.Oder;
import com.codegym.books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("bookList",iBookService.findAll());
        return "/list";
    }
    @GetMapping("/oder")
    public String showFormOder(@ModelAttribute(value = "id")int id,Model model){
        model.addAttribute("book",iBookService.findById(id));
        return "/oder";
    }
    @PostMapping("/oder")
    public String oder(RedirectAttributes redirectAttributes , @ModelAttribute("book")Book book){

//        double a = Math.floor(Math.random() * 1000)+100;
        iBookService.oderBook(book.getId());
        redirectAttributes.addFlashAttribute("mess","mượn truyện thành công");
        return "redirect:/book";
    }
    @GetMapping("/pay")
    public String showFormPay(){

        return "/pay";
    }
}
