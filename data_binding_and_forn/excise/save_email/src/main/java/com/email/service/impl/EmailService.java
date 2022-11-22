package com.email.service.impl;

import com.email.model.Email;
import com.email.repository.IEmailRepository;
import com.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public List<Email> findAll() {
        return iEmailRepository.findAll();
    }

    @Override
    public Email findById(int id) {
        return iEmailRepository.findById(id);
    }

    @Override
    public void update(Email email) {
        iEmailRepository.update(email);
    }


}
