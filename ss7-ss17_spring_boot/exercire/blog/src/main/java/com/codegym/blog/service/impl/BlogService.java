package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByAuthorContainingOrContent(String author, String content) {
        return iBlogRepository.findByAuthorContainingOrContent(author,content);
    }

    @Override
    public Page<Blog> searchAuthorAndTitle(String author, String content, Pageable pageable) {
        return iBlogRepository.searchAuthorAndTitle(author,content,pageable);
    }
}
