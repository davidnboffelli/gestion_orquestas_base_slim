package com.gruposei.gestion_orquestas.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "surveys_questions_options_answers")
public class SurveyQuestionOptionAnswer {

    @EmbeddedId
    private SurveyQuestionOptionAnswerKey id = new SurveyQuestionOptionAnswerKey();

    @ManyToOne(optional = false)
    @MapsId("optionId")
    @JoinColumn(name = "option_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SurveyQuestionOption surveyQuestionOption;
    @ManyToOne(optional = false)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    public SurveyQuestionOptionAnswer() {
    }

    public SurveyQuestionOptionAnswer(SurveyQuestionOptionAnswerKey id, SurveyQuestionOption surveyQuestionOption, User user) {
        this.id = id;
        this.surveyQuestionOption = surveyQuestionOption;
        this.user = user;
    }

    public SurveyQuestionOptionAnswerKey getId() {
        return id;
    }

    public void setId(SurveyQuestionOptionAnswerKey id) {
        this.id = id;
    }

    public SurveyQuestionOption getSurveyQuestionOption() {
        return surveyQuestionOption;
    }

    public void setSurveyQuestionOption(SurveyQuestionOption surveyQuestionOption) {
        this.surveyQuestionOption = surveyQuestionOption;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
