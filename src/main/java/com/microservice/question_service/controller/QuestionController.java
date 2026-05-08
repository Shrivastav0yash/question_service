package com.microservice.question_service.controller;

import com.microservice.question_service.entities.Question;
import com.microservice.question_service.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<?> getAllQuestions(){
        try{
            List<Question> allQuestions = questionService.getAllQuestions();
            return new ResponseEntity<>(allQuestions ,HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return new ResponseEntity<>(new ArrayList<>() ,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<?> getQuestionsByCategory(@PathVariable String category){
        try{
            List<Question> questionsByCategory = questionService.getQuestionsByCategory(category);
            return new ResponseEntity<>(questionsByCategory, HttpStatus.OK);
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return new ResponseEntity<>(new ArrayList<>() ,HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        try{
            String s = questionService.addQuestion(question);
            return new ResponseEntity<>(s, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return new ResponseEntity<>("Adding not possible ",HttpStatus.NOT_IMPLEMENTED);

    }

    @PutMapping("/update")
    public ResponseEntity<?> uodateQuestion(@RequestBody Question question){
        try{
            String s = questionService.addQuestion(question);
            return new ResponseEntity<>(s, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return new ResponseEntity<>("ID not found",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        try{
            questionService.deleteQuestion(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Generate Quiz
    // proivde question to create Quiz to Quiz
    //getScore
}
