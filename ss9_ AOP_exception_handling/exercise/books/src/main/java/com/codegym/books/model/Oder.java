package com.codegym.books.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double nameCode;


    public Oder() {
    }

    public Oder( double nameCode) {
        this.nameCode = nameCode;
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
}
