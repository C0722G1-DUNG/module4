package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.ICategoryRepository;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
   private ICategoryRepository iCategoryRepository ;
    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Category category) {
iCategoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {
iCategoryRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByAuthorContainingOrContent(String author, String content) {
        return null;
    }
}
