package com.gruposei.gestion_orquestas.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "surveys_questions_answers")
public class SurveyQuestionAnswer {

    @EmbeddedId
    private SurveyQuestionAnswerKey id = new SurveyQuestionAnswerKey();

    @ManyToOne(optional = false)
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SurveyQuestion surveyQuestion;
    @ManyToOne(optional = false)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;
    private String answer;

    public SurveyQuestionAnswer(SurveyQuestionAnswerKey id, SurveyQuestion surveyQuestion, User user, String answer) {
        this.id = id;
        this.surveyQuestion = surveyQuestion;
        this.user = user;
        this.answer = answer;
    }

    public SurveyQuestionAnswer() {
    }

    public SurveyQuestionAnswerKey getId() {
        return id;
    }

    public void setId(SurveyQuestionAnswerKey id) {
        this.id = id;
    }

    public SurveyQuestion getSurveyQuestion() {
        return surveyQuestion;
    }

    public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
        this.surveyQuestion = surveyQuestion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
