package com.codegym.module4.service.impl;

import com.codegym.module4.model.QuestionType;
import com.codegym.module4.repository.IQuestionTypeRepository;
import com.codegym.module4.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    private IQuestionTypeRepository iQuestionTypeRepository;
    @Override
    public Iterable<QuestionType> findAll() {
        return iQuestionTypeRepository.findAll();
    }

    @Override
    public Optional<QuestionType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(QuestionType questionType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
