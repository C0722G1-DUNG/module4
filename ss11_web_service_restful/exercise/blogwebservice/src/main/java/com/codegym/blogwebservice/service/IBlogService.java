package com.codegym.blogwebservice.service;
import com.codegym.blogwebservice.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {


    Page<Blog> searchAuthorAndTitle(@Param("author") String author, @Param("content") String content, Pageable pageable);
    Page<Blog> searchAuthor(@Param("author") String author,Pageable pageable);
    List<Blog> findByAuthorContains(String author);

}
