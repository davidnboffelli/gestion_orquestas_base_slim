package com.gruposei.gestion_orquestas.service;

import com.gruposei.gestion_orquestas.model.Cloth;
import com.gruposei.gestion_orquestas.repositories.ClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothService {

    @Autowired
    private ClothRepository clothRepository;

    public Cloth create(Cloth p){

        return clothRepository.save(p);
    }

    public List<Cloth> getAll(){

        return clothRepository.findAll();
    }

    public void delete(Cloth p){

        clothRepository.delete(p);
    }

    public void deleteById(Long id){

        clothRepository.deleteById(id);
    }

    public Optional<Cloth> findById(Long id){

        return clothRepository.findById(id);
    }
}
