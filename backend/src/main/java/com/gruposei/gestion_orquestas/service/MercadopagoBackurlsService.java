package com.gruposei.gestion_orquestas.service;

import com.gruposei.gestion_orquestas.model.MercadopagoBackurls;
import com.gruposei.gestion_orquestas.model.MercadopagoNotification;
import com.gruposei.gestion_orquestas.repositories.MercadopagoBackurlsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MercadopagoBackurlsService {

    @Autowired
    private MercadopagoBackurlsRepository mercadopagoBackurlsRepository;

    public MercadopagoBackurls create(MercadopagoBackurls p){

        return mercadopagoBackurlsRepository.save(p);
    }

    public List<MercadopagoBackurls> getAll(){

        return mercadopagoBackurlsRepository.findAll();
    }

    public void delete(MercadopagoBackurls p){

        mercadopagoBackurlsRepository.delete(p);
    }

    public Optional<MercadopagoBackurls> findById(Long id){

        return mercadopagoBackurlsRepository.findById(id);
    }
}
