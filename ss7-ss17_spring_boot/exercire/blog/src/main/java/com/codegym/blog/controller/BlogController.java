package com.codegym.blog.controller;


import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
@Autowired
    private IBlogService iBlogService;
@Autowired
 private ICategoryService iCategoryService;


    @GetMapping("")
    public String finAll(@RequestParam(defaultValue = "") String search,
                         @PageableDefault(value = 5) Pageable pageable, Model model){

        model.addAttribute("blogList",iBlogService.searchAuthorAndTitle(search,search,pageable));
        return "list";
}
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("categoryList",iCategoryService.findAll());
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
        model.addAttribute("categoryList",iCategoryService.findAll());
        model.addAttribute("blog",iBlogService.findById(id));
        return "/update";
    }
    @PostMapping("/update")
    public String update(Blog blog , RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("messages","update thành công");
        return "redirect:/blog";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("deleteById") int deleteById , RedirectAttributes redirectAttributes){
        String messages = "xóa thành công";
        iBlogService.remove(deleteById);
        redirectAttributes.addFlashAttribute("messages",messages);
        return "redirect:/blog";
    }
}
