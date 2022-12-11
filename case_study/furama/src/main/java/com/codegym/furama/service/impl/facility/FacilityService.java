package com.codegym.furama.service.impl.facility;

import com.codegym.furama.model.facility.Facility;
import com.codegym.furama.repository.IFacilityRepository;
import com.codegym.furama.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Override
    public Iterable<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public Optional<Facility> findById(Integer id) {
        return iFacilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
iFacilityRepository.save(facility);
    }

    @Override
    public void remove(Integer id) {
iFacilityRepository.deleteById(id);
    }


    @Override
    public Page<Facility> searchAndShow(String nameType, String name, Pageable pageable) {
        return iFacilityRepository.searchAndShow(nameType,name,pageable);
    }
}
