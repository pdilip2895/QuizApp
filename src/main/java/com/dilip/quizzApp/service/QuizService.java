package com.dilip.quizzApp.service;

import com.dilip.quizzApp.dao.QuestionDao;
import com.dilip.quizzApp.dao.QuizDao;
import com.dilip.quizzApp.entity.Question;
import com.dilip.quizzApp.entity.QuestionWrapper;
import com.dilip.quizzApp.entity.Quiz;
import com.dilip.quizzApp.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category, int numQ , String title ) {
        List<Question> questions = questionDao.findRandomQuestionsByCategory(category , numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success" , HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDb = quiz.get().getQuestions();
        ArrayList<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q : questionsFromDb){
            QuestionWrapper questionWrapper = new QuestionWrapper(
                    q.getId(),
                    q.getQuestionTitle(),
                    q.getOption1(),
                    q.getOption2(),
                    q.getOption3(),
                    q.getOption4()
            );
            questionsForUser.add(questionWrapper);
        }
        return new ResponseEntity<>(questionsForUser , HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateCorrectResponse(Integer id, List<Response> responses) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        int right = 0;
        int i = 0;
        for(Response resp : responses){
            if(resp.getResponse().equals(questions.get(i++).getRightAnswer())){
                right++;
            }
        }
        return new ResponseEntity<>(right , HttpStatus.OK);
    }
}
