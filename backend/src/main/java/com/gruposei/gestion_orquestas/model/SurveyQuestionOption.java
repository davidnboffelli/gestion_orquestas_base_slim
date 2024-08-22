package com.gruposei.gestion_orquestas.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "surveys_questions_options")
public class SurveyQuestionOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String option;
    @ManyToOne(optional = false)
    @JoinColumn(name = "question_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SurveyQuestion surveyQuestion;

    public SurveyQuestionOption(Long id, String option, SurveyQuestion surveyQuestion) {
        this.id = id;
        this.option = option;
        this.surveyQuestion = surveyQuestion;
    }

    public SurveyQuestionOption() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public SurveyQuestion getSurveyQuestion() {
        return surveyQuestion;
    }

    public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
        this.surveyQuestion = surveyQuestion;
    }
}
