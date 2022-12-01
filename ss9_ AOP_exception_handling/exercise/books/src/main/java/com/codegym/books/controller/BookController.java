package com.codegym.books.controller;

import com.codegym.books.model.Book;
import com.codegym.books.model.Oder;
import com.codegym.books.service.IBookService;
import com.codegym.books.service.IOderService;
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
    @Autowired
    private IOderService iOderService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("bookList", iBookService.findAll());
        return "/list";
    }

    @GetMapping("/oder")
    public String showFormOder(@ModelAttribute(value = "id") int id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "/oder";
    }

    @PostMapping("/oder")
    public String oder(RedirectAttributes redirectAttributes, @ModelAttribute("book") Book book) {
        double a = Math.floor(Math.random() * 100) + 10;
        Oder oder = new Oder(a, book);
        iOderService.save(oder);
        iBookService.oderBook(book.getId());
        redirectAttributes.addFlashAttribute("mess", "mượn truyện thành công");
        redirectAttributes.addFlashAttribute("code", "mượn truyện " + book.getNameBook() + "có mã là" + a);
        return "redirect:/book";
    }

    @GetMapping("/pay")
    public String showFormPay(@ModelAttribute(value = "id") int id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "/pay";
    }

    @PostMapping("/pay")
    public String pay(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes, int nameCode, Model model) {
        if (iOderService.isCheck(nameCode)) {
            iBookService.payBook(book.getId());
            redirectAttributes.addFlashAttribute("mess", "trả thành công");
            redirectAttributes.addFlashAttribute("mess1", "cảm ơn bạn và hẹn gặp lại");
            return "redirect:/book";
        }
        model.addAttribute("book", book);
        model.addAttribute("mess", "mã không đúng,xin nhập lại");
        return "book/pay";
    }
}
