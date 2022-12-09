package com.codegym.furama.service;

import com.codegym.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> searchAndShowList(@Param("name")String name, @Param("email")String email, @Param("nameType")String nameType, Pageable pageable);
}
