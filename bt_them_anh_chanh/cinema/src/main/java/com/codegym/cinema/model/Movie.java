package com.codegym.cinema.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameMovie;
@OneToMany(mappedBy = "movie")
private Set<ShowTimeCinema> showTimeCinemas;

    public Movie() {
    }

    public Movie(int id, String nameMovie, Set<ShowTimeCinema> showTimeCinemas) {
        this.id = id;
        this.nameMovie = nameMovie;
        this.showTimeCinemas = showTimeCinemas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public Set<ShowTimeCinema> getShowTimeCinemas() {
        return showTimeCinemas;
    }

    public void setShowTimeCinemas(Set<ShowTimeCinema> showTimeCinemas) {
        this.showTimeCinemas = showTimeCinemas;
    }
}
