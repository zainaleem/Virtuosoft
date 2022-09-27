package com.example.survey.controller;

import com.example.survey.model.Answer;
import com.example.survey.repository.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnswerController {

@Autowired
AnswerRepo answerRepository;

    @GetMapping("/answers")
    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }

    @PostMapping("/answers")
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answerDetails) {

            /* Question question = answerDetails.getQuestion();
             question.setQuestion(answerDetails);
             answerDetails.setQuestion(question);*/

            answerDetails = answerRepository.save(answerDetails);
        return new ResponseEntity<Answer>(answerDetails, HttpStatus.OK);
    }

    @PutMapping("/answers/{id}")
    public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answerDetails) {
        Answer updateAnswer = null;
        Optional<Answer> answerOptional = answerRepository.findById(answerDetails.getId());

        if (answerOptional.isPresent()) {
            updateAnswer = answerOptional.get();
            updateAnswer.setAnswer(answerDetails.getAnswer());

            answerRepository.save(updateAnswer);
        }
        return ResponseEntity.ok(updateAnswer);
    }



}
