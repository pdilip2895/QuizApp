package com.dilip.quizzApp.controller;

import com.dilip.quizzApp.entity.QuestionWrapper;
import com.dilip.quizzApp.entity.Response;
import com.dilip.quizzApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuizByCategory(@RequestParam String category , @RequestParam int numQ , @RequestParam String title){
       return quizService.createQuiz(category , numQ, title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(@PathVariable Integer id){
        return quizService.getQuizQuestionsById(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuizById(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateCorrectResponse(id , responses);
    }
}
