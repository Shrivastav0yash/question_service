package com.microservice.question_service.controller;

import com.microservice.question_service.entities.Question;
import com.microservice.question_service.entities.QuestionWrapper;
import com.microservice.question_service.entities.Response;
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

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions ){
        List<Integer> allQuestions = questionService.getQuestionForQuiz(categoryName, numQuestions);
        return new ResponseEntity<>(allQuestions, HttpStatus.CREATED);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionsIds){
        List<QuestionWrapper> questionsList = questionService.getQuestionsFromId(questionsIds);
        return new ResponseEntity<>(questionsList, HttpStatus.OK);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
        Integer result = questionService.getScore(responses);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
