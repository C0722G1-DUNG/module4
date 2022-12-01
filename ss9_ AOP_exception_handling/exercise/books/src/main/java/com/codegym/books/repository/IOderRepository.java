package com.codegym.books.repository;

import com.codegym.books.model.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOderRepository extends JpaRepository<Oder,Integer> {
    @Modifying
    @Transactional
    @Query(value = "SELECT name_code FROM oder",nativeQuery = true)
    List<Double> showCode();
}
