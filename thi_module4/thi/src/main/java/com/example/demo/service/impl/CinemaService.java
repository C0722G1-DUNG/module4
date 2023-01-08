package com.example.demo.service.impl;


import com.example.demo.model.ShowTimeCinema;
import com.example.demo.repository.IShowTimeCinemaRepository;
import com.example.demo.service.IShowTimeCinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService implements IShowTimeCinemaService {
    @Autowired
    private IShowTimeCinemaRepository iShowTimeCinemaRepository;
    @Override
    public Iterable<ShowTimeCinema> findAll() {
        return iShowTimeCinemaRepository.findAll();
    }

    @Override
    public Optional<ShowTimeCinema> findById(Integer id) {
        return iShowTimeCinemaRepository.findById(id);
    }

    @Override
    public void save(ShowTimeCinema showTimeCinema) {
iShowTimeCinemaRepository.save(showTimeCinema);
    }

    @Override
    public void remove(Integer id) {
iShowTimeCinemaRepository.deleteById(id);
    }

    @Override
    public List<ShowTimeCinema> findAllStatusOne() {
        return iShowTimeCinemaRepository.findAllStatusOne();
    }

    @Override
    public void delete(String deleteByCinemaCode) {
        iShowTimeCinemaRepository.delete(deleteByCinemaCode);
    }
}
