package com.gruposei.gestion_orquestas.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SurveyQuestionOptionAnswerKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "option_id")
    private Long optionId;

    public SurveyQuestionOptionAnswerKey() {
    }

    public SurveyQuestionOptionAnswerKey(Long userId, Long optionId) {
        this.userId = userId;
        this.optionId = optionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOptionId() {
        return optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }
}
