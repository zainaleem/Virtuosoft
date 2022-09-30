package com.example.survey.controller;

import com.example.survey.model.Option;
import com.example.survey.model.Question;
import com.example.survey.model.User;
import com.example.survey.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    QuestionRepo questionRepository;

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @PostMapping("/questions")
    public ResponseEntity<Question> createQuestion(@RequestBody Question questionDetails) {

        List<Option> options = questionDetails.getOptions();
        for(Option option : options){
            option.setQuestion(questionDetails);
        }
        questionDetails.setOptions(options);
        questionDetails = questionRepository.save(questionDetails);
        return new ResponseEntity<Question>(questionDetails, HttpStatus.OK);
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question questionDetails) {
        Question updateQuestion = null;
        Optional<Question> questionOptional = questionRepository.findById(questionDetails.getId());

        if (questionOptional.isPresent()) {
            updateQuestion = questionOptional.get();
            updateQuestion.setQuestion(questionDetails.getQuestion());
            updateQuestion.setAnswerType(questionDetails.getAnswerType());

            questionRepository.save(updateQuestion);
        }
        return ResponseEntity.ok(updateQuestion);
    }

}
