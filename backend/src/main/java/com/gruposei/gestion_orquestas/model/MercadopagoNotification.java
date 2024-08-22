package com.gruposei.gestion_orquestas.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mercadopago_notifications")
public class MercadopagoNotification {

    @Id
    private String id;
    private String action;
    private String api_version;
    private String application_id;
    private String date_created;
    private String live_mode;
    private String type;
    private String user_id;
    private String version;
    private String data_id;
//    {
//        "id": 12345,
//            "live_mode": true,
//            "type": "payment",
//            "date_created": "2015-03-25T10:04:58.396-04:00",
//            "application_id": 123123123,
//            "user_id": 44444,
//            "version": 1,
//            "api_version": "v1",
//            "action": "payment.created",
//            "data": {
//        "id": "999999999"
//    }
//    }
    public MercadopagoNotification() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getApi_version() {
        return api_version;
    }

    public void setApi_version(String api_version) {
        this.api_version = api_version;
    }

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getLive_mode() {
        return live_mode;
    }

    public void setLive_mode(String live_mode) {
        this.live_mode = live_mode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getData() {
        return data_id;
    }

    public void setData(String data) {
        this.data_id = data_id;
    }
}

