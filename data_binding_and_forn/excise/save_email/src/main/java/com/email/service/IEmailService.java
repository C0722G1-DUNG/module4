package com.email.service;

import com.email.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();
 Email findById(int id);
 void update(Email email);
}
