package com.codegym.validate_song.service.impl;

import com.codegym.validate_song.model.Music;
import com.codegym.validate_song.repository.IMusicRepository;
import com.codegym.validate_song.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MusicService implements IMusicService {
    @Autowired
 private    IMusicRepository iMusicRepository;
    @Override
    public Iterable<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public Optional<Music> findById(Integer id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public void save(Music music) {
iMusicRepository.save(music);
    }

    @Override
    public void remove(Long id) {

    }
}
