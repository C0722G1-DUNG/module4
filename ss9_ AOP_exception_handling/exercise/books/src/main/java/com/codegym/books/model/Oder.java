package com.codegym.books.model;

import javax.persistence.*;

@Entity
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double nameCode;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")

    private  Book book;


    public Oder() {
    }

    public Oder(double nameCode, Book book) {
        this.nameCode = nameCode;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNameCode() {
        return nameCode;
    }

    public void setNameCode(double nameCode) {
        this.nameCode = nameCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
