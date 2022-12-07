package com.codegym.blogwebservice.repository;
import com.codegym.blogwebservice.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    //c1 dùng string boot
    List<Blog> findByAuthorContains(String author);
    //c2 dùng câu queri
    @Query(value="select b.* from `Blog` b where b.author like  concat('%',:author,'%') or b.content like  concat('%',:content,'%')"
            ,nativeQuery = true)
    Page<Blog> searchAuthorAndTitle(@Param("author") String author, @Param("content") String content, Pageable pageable);


    @Query(value="select b.* from `Blog` b where b.author like  concat('%',:author,'%')"
            ,nativeQuery = true)
    Page<Blog> searchAuthor(@Param("author") String author,Pageable pageable);

}
