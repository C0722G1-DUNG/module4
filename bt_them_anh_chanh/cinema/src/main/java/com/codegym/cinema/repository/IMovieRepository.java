package com.codegym.cinema.repository;

import com.codegym.cinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie,Integer> {
}
