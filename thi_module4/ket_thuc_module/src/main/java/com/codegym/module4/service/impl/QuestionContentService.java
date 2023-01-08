package com.codegym.module4.service.impl;

import com.codegym.module4.model.QuestionContent;
import com.codegym.module4.repository.IQuestionContentRepository;
import com.codegym.module4.service.IQuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionContentService implements IQuestionContentService {
    @Autowired
    private IQuestionContentRepository iQuestionContentRepository;

    @Override
    public Iterable<QuestionContent> findAll() {
        return iQuestionContentRepository.findAll();
    }

    @Override
    public Optional<QuestionContent> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(QuestionContent questionContent) {
iQuestionContentRepository.save(questionContent);
    }

    @Override
    public void remove(Integer id) {
        iQuestionContentRepository.deleteById(id);
    }


    @Override
    public Page<QuestionContent> searchAndShowList(String title, Pageable pageable) {
        return iQuestionContentRepository.searchAndShowList(title,pageable);
    }

    @Override
    public Page<QuestionContent> searchAndShowList1(String title, Integer idQuestionType, Pageable pageable) {
        return iQuestionContentRepository.searchAndShowList1(title,idQuestionType,pageable);
    }
}
