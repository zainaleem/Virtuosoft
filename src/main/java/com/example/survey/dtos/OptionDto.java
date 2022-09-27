package com.example.survey.dtos;

import com.example.survey.bases.BaseDto;

public class OptionDto extends BaseDto {

    private String optionName;

    private QuestionDto questionDto;

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public QuestionDto getQuestionDto() {
        return questionDto;
    }

    public void setQuestionDto(QuestionDto questionDto) {
        this.questionDto = questionDto;
    }
}
