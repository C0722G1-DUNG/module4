package com.codegym.furama.model.customer;

import com.codegym.furama.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(name = "name")
    private String nameCustomer;
@Column(name = "date_of_birth")
    private String birthday;
    private boolean gender;
    private String id_card;
    @Column(name = "phone_number")
    private String phone;
    private String email;
    private String address;
    @ManyToOne()
    @JoinColumn(name =  "customer_type_id",referencedColumnName = "id")
    private CustomerType customerType;
    @OneToMany(mappedBy = "customer")
    private Set<Contract> contracts;

    public Customer() {
    }

    public Customer(int id, String nameCustomer, String birthday, boolean gender, String id_card, String phone, String email, String address, CustomerType customerType, Set<Contract> contracts) {
        this.id = id;
        this.nameCustomer = nameCustomer;
        this.birthday = birthday;
        this.gender = gender;
        this.id_card = id_card;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
