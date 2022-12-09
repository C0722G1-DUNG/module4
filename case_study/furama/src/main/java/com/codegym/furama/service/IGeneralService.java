package com.codegym.furama.service;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);
}
