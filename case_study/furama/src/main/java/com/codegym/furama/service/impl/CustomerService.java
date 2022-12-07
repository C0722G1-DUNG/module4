package com.codegym.furama.service.impl;

import com.codegym.furama.model.customer.Customer;
import com.codegym.furama.repository.ICustomerRepository;
import com.codegym.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;
    @Override
    public Iterable<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
iCustomerRepository.deleteById(id);
    }
}
