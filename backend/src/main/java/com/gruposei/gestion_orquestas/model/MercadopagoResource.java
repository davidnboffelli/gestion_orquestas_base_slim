package com.gruposei.gestion_orquestas.model;

import com.mercadopago.resources.datastructures.preference.Item;
//import lombok.Data;

import java.util.List;

//@Data
public class MercadopagoResource {

    //private String id;
    private String preferenceID;
    private String initPoint;
    private String sandboxInitPoint;
    private String externalReference;
    //private List<Item> items;


    public MercadopagoResource() {
    }

    public String getPreferenceID() {
        return preferenceID;
    }

    public void setPreferenceID(String preferenceID) {
        this.preferenceID = preferenceID;
    }

    public String getInitPoint() {
        return initPoint;
    }

    public void setInitPoint(String initPoint) {
        this.initPoint = initPoint;
    }

    public String getSandboxInitPoint() {
        return sandboxInitPoint;
    }

    public void setSandboxInitPoint(String sandboxInitPoint) {
        this.sandboxInitPoint = sandboxInitPoint;
    }

    public String getExternalReference() {
        return externalReference;
    }

    public void setExternalReference(String externalReference) {
        this.externalReference = externalReference;
    }
}