package com.dilip.quizzApp.dao;

import com.dilip.quizzApp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
