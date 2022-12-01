package com.codegym.books.service.impl;

import com.codegym.books.model.Book;
import com.codegym.books.repository.IBookRepository;
import com.codegym.books.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public Iterable<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return iBookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
iBookRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
iBookRepository.deleteById(id);
    }

    @Override
    public void oderBook(int id) {
        iBookRepository.oderBook(id);
    }

    @Override
    public void payBook(int id) {
        iBookRepository.payBook(id);
    }

}
