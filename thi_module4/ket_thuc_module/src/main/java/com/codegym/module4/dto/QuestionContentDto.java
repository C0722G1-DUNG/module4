package com.codegym.module4.dto;

import com.codegym.module4.model.QuestionContent;
import com.codegym.module4.model.QuestionType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class QuestionContentDto implements Validator {
    private int id;
    private String title;
    private String content;
    private String answer;
    private String dataCreate;
    private QuestionType questionType;

    public QuestionContentDto() {
    }

    public QuestionContentDto(int id, String title, String content, String answer, String dataCreate, QuestionType questionType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.dataCreate = dataCreate;
        this.questionType = questionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(String dataCreate) {
        this.dataCreate = dataCreate;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        QuestionContentDto questionContentDto = (QuestionContentDto) target;
//        if (!questionContentDto.getTitle().matches("")) {
//            errors.rejectValue("title", "title", "Không được để trống");
//        }
        if (questionContentDto.getAnswer().matches("")) {
            errors.rejectValue("answer","answer","Không được để trống");
        }
        if (questionContentDto.getContent().matches("")) {
            errors.rejectValue("content","content","Không được để trống");
        }
        if (questionContentDto.getDataCreate().matches("")) {
            errors.rejectValue("dataCreate","dataCreate","Không được để trống");
        }
    }
}
