package com.codegym.blogwebservice.controller;

import com.codegym.blogwebservice.model.Blog;
import com.codegym.blogwebservice.model.Category;
import com.codegym.blogwebservice.service.IBlogService;
import com.codegym.blogwebservice.service.ICategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> list(@PageableDefault(page = 0, value = 5) Pageable pageable,@RequestParam(value = "search",defaultValue = "") String search) {
        Page<Blog> blogList =  iBlogService.searchAuthor(search,pageable);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        iBlogService.save(blog);
        Blog blog1 = iBlogService.findById(blog.getId()).get();
        return new ResponseEntity<>(blog1, HttpStatus.CREATED);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Blog> view(@PathVariable("id") int id) {
        Optional<Blog> blog = iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(blog, HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Blog> update(@PathVariable("id") int id, @RequestBody Blog blog) {
        Optional<Blog> blog1 = iBlogService.findById(id);
        if (blog1==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.save(blog);
        return new ResponseEntity(blog1, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") int id){
        Optional<Blog> blog = iBlogService.findById(id);
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.remove(id);
        return new ResponseEntity(blog, HttpStatus.OK);
    }

}
