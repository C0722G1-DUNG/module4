package com.codegym.blogwebservice.service.impl;

import com.codegym.blogwebservice.model.Blog;
import com.codegym.blogwebservice.model.Category;
import com.codegym.blogwebservice.repository.ICategoryRepository;
import com.codegym.blogwebservice.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
   private ICategoryRepository iCategoryRepository ;
    @Override
    public Page<Category> findAll(Pageable pageable) {
        return iCategoryRepository.findAll(pageable);
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

}
