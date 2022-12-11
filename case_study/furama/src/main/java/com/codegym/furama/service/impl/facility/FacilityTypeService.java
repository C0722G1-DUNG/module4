package com.codegym.furama.service.impl.facility;

import com.codegym.furama.model.facility.FacilityType;
import com.codegym.furama.repository.IFacilityTypeRepository;
import com.codegym.furama.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;
    @Override
    public Iterable<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }

    @Override
    public Optional<FacilityType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(FacilityType facilityType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
