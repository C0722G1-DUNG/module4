package com.codegym.books.service;

import com.codegym.books.model.Book;
import org.springframework.data.repository.query.Param;

public interface IBookService extends IGeneralService<Book> {
    void oderBook(int id);
    void payBook(@Param("id") int id );

}
