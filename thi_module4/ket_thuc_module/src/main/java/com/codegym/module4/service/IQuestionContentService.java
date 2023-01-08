package com.codegym.module4.service;

import com.codegym.module4.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IQuestionContentService extends IGeneralService<QuestionContent> {
    Page<QuestionContent> searchAndShowList(@Param("title") String title, Pageable pageable);

    Page<QuestionContent> searchAndShowList1(@Param("title") String title,@Param("idQuestionType") Integer idQuestionType , Pageable pageable);
}
