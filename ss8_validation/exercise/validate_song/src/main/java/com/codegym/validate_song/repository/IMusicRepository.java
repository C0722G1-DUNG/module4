package com.codegym.validate_song.repository;

import com.codegym.validate_song.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music,Integer> {
}