package com.example.survey.dtos;

import com.example.survey.bases.BaseDto;
import com.example.survey.enums.Type;

public class QuestionDto extends BaseDto {

    private String question;

    private Type type;

    private OptionDto optionDto;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public OptionDto getOptionDto() {
        return optionDto;
    }

    public void setOptionDto(OptionDto optionDto) {
        this.optionDto = optionDto;
    }
}
