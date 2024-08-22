package com.gruposei.gestion_orquestas.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "surveys_questions")
public class SurveyQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne(optional = false)
    @JoinColumn(name = "survey_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Survey survey;
    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SurveyQuestionType surveyQuestionType;

    public SurveyQuestion(Long id, String title, Survey survey, SurveyQuestionType surveyQuestionType) {
        this.id = id;
        this.title = title;
        this.survey = survey;
        this.surveyQuestionType = surveyQuestionType;
    }

    public SurveyQuestion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public SurveyQuestionType getSurveyQuestionType() {
        return surveyQuestionType;
    }

    public void setSurveyQuestionType(SurveyQuestionType surveyQuestionType) {
        this.surveyQuestionType = surveyQuestionType;
    }
}
