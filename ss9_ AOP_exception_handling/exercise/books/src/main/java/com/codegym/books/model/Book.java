package com.codegym.books.model;
import javax.persistence.*;

@Entity
public class Book  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String nameBook;
    private String content;
    private int amount;
    @ManyToOne
    private Oder oder;
    public Book() {
    }

    public Book(int id, String nameBook, String content, int amount, Oder oder) {
        this.id = id;
        this.nameBook = nameBook;
        this.content = content;
        this.amount = amount;
        this.oder = oder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Oder getOder() {
        return oder;
    }

    public void setOder(Oder oder) {
        this.oder = oder;
    }
}
