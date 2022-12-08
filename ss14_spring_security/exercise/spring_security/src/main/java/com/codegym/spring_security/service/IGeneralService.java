package com.codegym.spring_security.service;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
public interface IGeneralService<T> {
    Iterable<T> findAll(Pageable pageable);

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);
}
