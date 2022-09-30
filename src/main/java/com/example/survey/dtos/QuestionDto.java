package com.example.survey.dtos;

import com.example.survey.bases.BaseDto;
import com.example.survey.enums.AnswerType;

public class QuestionDto extends BaseDto {

    private String question;

    private AnswerType answerType;

    private OptionDto optionDto;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public OptionDto getOptionDto() {
        return optionDto;
    }

    public void setOptionDto(OptionDto optionDto) {
        this.optionDto = optionDto;
    }
}
