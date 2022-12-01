package com.codegym.books.service.impl;

import com.codegym.books.model.Oder;
import com.codegym.books.repository.IOderRepository;
import com.codegym.books.service.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OderService implements IOderService {
    @Autowired
    private IOderRepository iOderRepository;
    @Override
    public Iterable<Oder> findAll() {
        return null;
    }

    @Override
    public Optional<Oder> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Oder oder) {
iOderRepository.save(oder);
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Oder findByBookRentalCode(long bookRentalCode) {
        List<Oder> oderBookList = iOderRepository.findAll();
        for (Oder item : oderBookList) {
            if (item.getNameCode() == bookRentalCode) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<Double> showCode() {
        return iOderRepository.showCode();
    }

    @Override
    public boolean isCheck(double bookCode) {
        List<Double> codeList = showCode();
        for (int i = 0; i < codeList.size(); i++) {
            if (codeList.get(i) == bookCode) {
                return true;
            }
        }
        return false;
    }
}
