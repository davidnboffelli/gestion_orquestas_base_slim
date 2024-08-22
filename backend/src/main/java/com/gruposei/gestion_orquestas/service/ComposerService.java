package com.gruposei.gestion_orquestas.service;

import com.gruposei.gestion_orquestas.model.Cloth;
import com.gruposei.gestion_orquestas.model.Composer;
import com.gruposei.gestion_orquestas.repositories.ClothRepository;
import com.gruposei.gestion_orquestas.repositories.ComposerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComposerService {

    @Autowired
    private ComposerRepository composerRepository;

    public Composer create(Composer p){

        return composerRepository.save(p);
    }

    public List<Composer> getAll(){

        return composerRepository.findAll();
    }

    public void delete(Composer p){

        composerRepository.delete(p);
    }

    public void deleteById(Long id){

        composerRepository.deleteById(id);
    }

    public Optional<Composer> findById(Long id){

        return composerRepository.findById(id);
    }
}
