package com.codegym.module4.repository;

import com.codegym.module4.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IQuestionContentRepository extends JpaRepository<QuestionContent, Integer> {
    @Query(value = "select * from question_content where title like concat('%',:title,'%') order by id", countQuery = "select * from question_content where title like concat('%',:title,'%') order by id ", nativeQuery = true)
    Page<QuestionContent> searchAndShowList(@Param("title") String title, Pageable pageable);


    @Query(value = "select * from question_content where title like concat('%',:title,'%') and id_question_type like '%,:idQuestionType,%' order by id", countQuery = "select * from question_content where title like concat('%',:title,'%') and id_question_type like '%,:idQuestionType,%' order by id ", nativeQuery = true)
    Page<QuestionContent> searchAndShowList1(@Param("title") String title,@Param("idQuestionType") Integer idQuestionType , Pageable pageable);

}
