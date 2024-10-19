package com.dilip.quizzApp.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultyLevel;
    private String category;
}
