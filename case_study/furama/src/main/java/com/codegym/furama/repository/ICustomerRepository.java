package com.codegym.furama.repository;

import com.codegym.furama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
@Query(value="select * from customer c join customer_type ct on ct.id=c.customer_type_id where c.name " +
        "like concat('%', :name ,'%')  and c.email like concat('%', :email,'%')  and ct.name like concat('%',:nameType,'%')"
        ,countQuery = "select * from(select *from customer c join customer_type ct on ct.id=c.customer_type_id where" +
        " c.name like concat('%', :name ,'%')  and c.email like concat('%', :email,'%')  and ct.name like concat('%',:nameType,'%'))abc ",nativeQuery = true)
    Page<Customer> searchAndShowList(@Param("name")String name, @Param("email")String email, @Param("nameType")String nameType, Pageable pageable);
}
