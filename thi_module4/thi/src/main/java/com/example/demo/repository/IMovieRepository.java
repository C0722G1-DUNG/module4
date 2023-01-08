package com.example.demo.repository;


import com.example.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie,Integer> {
}
