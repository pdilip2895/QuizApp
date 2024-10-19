package com.dilip.quizzApp.dao;

import com.dilip.quizzApp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "Select * from question q where q.category=:category order by RAND( ) limit :numQ" , nativeQuery = true)
    public List<Question> findRandomQuestionsByCategory(String category , int numQ);
}