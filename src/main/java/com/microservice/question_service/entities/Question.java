package com.microservice.question_service.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String questionTitle;

    private String category;

    private String option1;
    private String option2;
    private String option3;
    private String option4;

    private String rightAnswer;
    private String difficultyLevel;

}
