package com.codegym.validate_song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MusicDto implements Validator {
    private int id;
    private String nameMusic;
    private String performingArtist;
    private String musicGenre;



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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        if (!musicDto.getNameMusic().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
            errors.rejectValue("nameMusic", "nameMusic", "tên bài hát không hợp lệ");
        }
        if (!musicDto.getPerformingArtist().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")){
            errors.rejectValue("performingArtist","performingArtist","Nghệ sĩ thể hiện không hợp lệ ");
        }
        if (!musicDto.getMusicGenre().matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")){
            errors.rejectValue("musicGenre","musicGenre","Thể loại nhạc không hợp lệ");
        }
    }
}
