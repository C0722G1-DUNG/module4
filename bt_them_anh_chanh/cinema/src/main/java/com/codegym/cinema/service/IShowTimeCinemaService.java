package com.codegym.cinema.service;

import com.codegym.cinema.model.ShowTimeCinema;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IShowTimeCinemaService extends IGeneralService<ShowTimeCinema> {
    List<ShowTimeCinema> findAllStatusOne();
    void delete(@Param("deleteByCinemaCode") String deleteByCinemaCode);
}
