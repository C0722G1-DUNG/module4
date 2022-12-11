package com.codegym.furama.service.impl.customer;

import com.codegym.furama.model.customer.CustomerType;
import com.codegym.furama.repository.ICustomerTypeRepository;
import com.codegym.furama.service.ICustomerService;
import com.codegym.furama.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public Iterable<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public Optional<CustomerType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(CustomerType customerType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
