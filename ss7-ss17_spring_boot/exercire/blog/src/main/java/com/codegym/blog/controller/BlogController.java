package com.codegym.blog.controller;


import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
@Autowired
    private IBlogService iBlogService;
    @GetMapping("")
    public String finAll( Model model){

        model.addAttribute("blogList",iBlogService.findAll());

        return "list";
}
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }
    @PostMapping("/create")
    public String create(Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("messages","thêm mới thành công");
        return "redirect:/blog/create";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") int id , Model model){

        model.addAttribute("blog",iBlogService.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update(Blog blog , RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("messages","update thanh cong");
        return "redirect:/blog";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("deleteById") int deleteById , RedirectAttributes redirectAttributes){
        String messages = "xoa thanh cong";
        iBlogService.remove(deleteById);
        redirectAttributes.addFlashAttribute("messages",messages);
        return "redirect:/blog";
    }
}
