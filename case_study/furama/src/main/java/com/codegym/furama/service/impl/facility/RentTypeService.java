package com.codegym.furama.service.impl.facility;
import com.codegym.furama.model.facility.RentType;
import com.codegym.furama.repository.IRentTypeRepository;
import com.codegym.furama.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;
    @Override
    public Iterable<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }

    @Override
    public Optional<RentType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(RentType rentType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
