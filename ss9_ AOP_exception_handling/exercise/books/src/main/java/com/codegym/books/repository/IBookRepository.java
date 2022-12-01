package com.codegym.books.repository;

import com.codegym.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IBookRepository extends JpaRepository<Book,Integer> {
    @Transactional
    @Modifying
    @Query(value="update book  set amount = amount-1 where id =:id",nativeQuery = true)
    void oderBook(@Param("id") int id );
    @Transactional
    @Modifying
    @Query(value="update book  set amount = amount+1 where id =:id",nativeQuery = true)
    void payBook(@Param("id") int id );
    @Transactional
    @Modifying
    @Query(value="insert into oder(name_code) values (:name_code)",nativeQuery = true)
    void nameCode(@Param("name_code")int name_code);
}
