package com.gruposei.gestion_orquestas.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserClothKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "cloth_id")
    private Long clothId;

    public UserClothKey() {
    }

    public UserClothKey(Long userId, Long clothId) {
        this.userId = userId;
        this.clothId = clothId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getClothId() {
        return clothId;
    }

    public void setClothId(Long clothId) {
        this.clothId = clothId;
    }
}
