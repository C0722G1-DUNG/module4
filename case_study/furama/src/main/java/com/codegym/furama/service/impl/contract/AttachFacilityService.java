package com.codegym.furama.service.impl.contract;

import com.codegym.furama.model.contract.AttachFacility;
import com.codegym.furama.repository.IAttachFacilityRepository;
import com.codegym.furama.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;
    @Override
    public Iterable<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }

    @Override
    public Optional<AttachFacility> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(AttachFacility attachFacility) {

    }

    @Override
    public void remove(Integer id) {

    }
}
