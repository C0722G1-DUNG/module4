package com.codegym.furama.model.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name = "name")
    private String nameCustomerType;
    @JsonBackReference
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(int id, String nameCustomerType, Set<Customer> customers) {
        this.id = id;
        this.nameCustomerType = nameCustomerType;
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustomerType() {
        return nameCustomerType;
    }

    public void setNameCustomerType(String nameCustomerType) {
        this.nameCustomerType = nameCustomerType;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
