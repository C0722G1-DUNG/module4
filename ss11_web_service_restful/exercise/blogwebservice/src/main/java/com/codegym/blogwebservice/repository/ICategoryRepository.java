package com.codegym.blogwebservice.repository;
import com.codegym.blogwebservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer>  {
}
