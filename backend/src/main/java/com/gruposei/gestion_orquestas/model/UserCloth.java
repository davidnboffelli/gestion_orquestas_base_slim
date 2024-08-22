package com.gruposei.gestion_orquestas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "users_clothes")
public class UserCloth {

    @EmbeddedId
    private UserClothKey id = new UserClothKey();

    @ManyToOne(optional = false)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(optional = false)
    @MapsId("clothId")
    @JoinColumn(name = "cloth_id")
    private Cloth cloth;

    @ManyToOne
    @JoinColumn(name = "cloth_scale_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ClothScale clothScale;

    public UserCloth() {
    }

    public UserClothKey getId() {
        return id;
    }

    public void setId(UserClothKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    public ClothScale getClothScale() {
        return clothScale;
    }

    public void setClothScale(ClothScale clothScale) {
        this.clothScale = clothScale;
    }
}
