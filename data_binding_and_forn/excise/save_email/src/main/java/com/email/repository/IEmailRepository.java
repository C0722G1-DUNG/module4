package com.email.repository;

import com.email.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> findAll();
    Email findById(int id);
    void update(Email email);
}
