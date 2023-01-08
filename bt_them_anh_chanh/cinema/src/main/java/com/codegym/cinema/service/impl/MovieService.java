package com.codegym.cinema.service.impl;

import com.codegym.cinema.model.Movie;
import com.codegym.cinema.service.IMovieService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MovieService implements IMovieService {
    @Override
    public Iterable<Movie> findAll() {
        return null;
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Movie movie) {

    }

    @Override
    public void remove(Integer id) {

    }
}
