package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {


    Page<Blog> searchAuthorAndTitle(@Param("author") String author, @Param("content") String content, Pageable pageable);
}
