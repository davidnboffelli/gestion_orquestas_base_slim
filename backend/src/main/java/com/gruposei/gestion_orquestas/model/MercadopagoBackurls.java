package com.gruposei.gestion_orquestas.model;

import javax.persistence.*;

@Entity
@Table(name = "mercadopago_backurls")
public class MercadopagoBackurls {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String payment_id;
    private String status;
    private String external_reference;
    private String comerciante_order_id;

    public MercadopagoBackurls() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExternal_reference() {
        return external_reference;
    }

    public void setExternal_reference(String external_reference) {
        this.external_reference = external_reference;
    }

    public String getComerciante_order_id() {
        return comerciante_order_id;
    }

    public void setComerciante_order_id(String comerciante_order_id) {
        this.comerciante_order_id = comerciante_order_id;
    }
}