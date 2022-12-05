package com.codegym.books.service;

import com.codegym.books.model.Oder;

import java.util.List;

public interface IOderService extends IGeneralService<Oder> {
    Oder findByBookRentalCode(long bookRentalCode);
    List<Double> showCode();
    boolean isCheck(double bookCode);
    void deleteOderByNameCode(int id );
    Oder findByNameCode(double nameCode);
}
