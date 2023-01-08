package com.codegym.cinema.service.impl;

import com.codegym.cinema.model.ShowTimeCinema;
import com.codegym.cinema.repository.IShowTimeCinemaRepository;
import com.codegym.cinema.service.IGeneralService;
import com.codegym.cinema.service.IShowTimeCinemaService;
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
