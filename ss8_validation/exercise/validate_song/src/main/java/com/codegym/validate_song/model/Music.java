package com.codegym.validate_song.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @NotBlank(message = "không được để trống")
    @Size(min = 0,max = 800 , message = "ký tự không vượt quá 800")
    private String nameMusic;
    @NotBlank(message = "không được để trống")
    @Size(min = 0,max = 800 , message = "ký tự không vượt quá 800")
    private String performingArtist;
    @NotBlank(message = "không được để trống")
    @Size(min = 0,max = 800 , message = "ký tự không vượt quá 800")
    private String musicGenre;

    public Music(int id, String nameMusic, String performingArtist, String musicGenre) {
        this.id = id;
        this.nameMusic = nameMusic;
        this.performingArtist = performingArtist;
        this.musicGenre = musicGenre;
    }

    public Music() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getPerformingArtist() {
        return performingArtist;
    }

    public void setPerformingArtist(String performingArtist) {
        this.performingArtist = performingArtist;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }
}
