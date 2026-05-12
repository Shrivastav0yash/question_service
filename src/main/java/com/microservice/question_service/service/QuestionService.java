package com.microservice.question_service.service;


import com.microservice.question_service.entities.Question;
import com.microservice.question_service.entities.QuestionWrapper;
import com.microservice.question_service.entities.Response;
import com.microservice.question_service.repository.QuestionsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionsRepo questionsRepo;

    public List<Question> getAllQuestions(){
        return questionsRepo.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionsRepo.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionsRepo.save(question);
        return "Question add successfully";
    }

    public void deleteQuestion(Long id) {
        questionsRepo.deleteById(id);
    }


    public List<Integer> getQuestionForQuiz(String categoryName, Integer numQuestions) {
        return questionsRepo.findRandomQuestionsByCategory(categoryName, numQuestions);
    }


    public List<QuestionWrapper> getQuestionsFromId(List<Integer> questionsIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();

        for(Integer id : questionsIds){
            questions.add(questionsRepo.findById(Long.valueOf(id)).get());
        }
        for(Question question : questions){
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestionTitle(question.getQuestionTitle());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            wrappers.add(wrapper);
        }

        return wrappers;
    }

    public Integer getScore(List<Response> responses) {
        int right = 0;
        for(Response response : responses){
            Question question = questionsRepo.findById(Long.valueOf(response.getId())).get();
            if(response.getResponse().equals(question.getRightAnswer()))
                right++;
        }
        return right;
    }
}
