package com.codegym.blogwebservice.service.impl;
import com.codegym.blogwebservice.model.Blog;
import com.codegym.blogwebservice.repository.IBlogRepository;
import com.codegym.blogwebservice.service.IBlogService;
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
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
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
