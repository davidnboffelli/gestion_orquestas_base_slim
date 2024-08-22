package com.gruposei.gestion_orquestas.service;

import com.gruposei.gestion_orquestas.model.MeetingMinute;
import com.gruposei.gestion_orquestas.model.MercadopagoNotification;
import com.gruposei.gestion_orquestas.repositories.MercadopagoNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercadopagoNotificationService {

    @Autowired
    private MercadopagoNotificationRepository mercadopagoNotificationRepository;

    public MercadopagoNotification create(MercadopagoNotification p){

        return mercadopagoNotificationRepository.save(p);
    }

    public List<MercadopagoNotification> getAll(){

        return mercadopagoNotificationRepository.findAll();
    }

    public void delete(MercadopagoNotification p){

        mercadopagoNotificationRepository.delete(p);
    }

    public Optional<MercadopagoNotification> findById(String id){

        return mercadopagoNotificationRepository.findById(id);
    }
}
