package com.dilip.quizzApp.service;

import com.dilip.quizzApp.dao.QuestionDao;
import com.dilip.quizzApp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions(){
       try {
           return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
       }catch (Exception e){
           e.printStackTrace();
       }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }
    public ResponseEntity<Question> addQuestion(Question question) {
        Question savedQuestion = questionDao.save(question);
        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);
    }
}
