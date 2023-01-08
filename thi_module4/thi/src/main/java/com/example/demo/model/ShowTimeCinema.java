package com.example.demo.model;

import javax.persistence.*;

@Entity
public class ShowTimeCinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cinemaCode;
    private String startDate;
    private String slot;
    @Column(columnDefinition = "int default 1")
    private int status = 1;
    @ManyToOne()
    @JoinColumn(name = "movie_id",referencedColumnName = "id")
    private Movie movie;

    public ShowTimeCinema() {
    }


    public ShowTimeCinema(int id, String cinemaCode, String startDate, String slot, int status, Movie movie) {
        this.id = id;
        this.cinemaCode = cinemaCode;
        this.startDate = startDate;
        this.slot = slot;
        this.status = status;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCinemaCode() {
        return cinemaCode;
    }

    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
