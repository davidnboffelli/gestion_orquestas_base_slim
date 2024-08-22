package com.gruposei.gestion_orquestas.service;

import com.gruposei.gestion_orquestas.model.Cloth;
import com.gruposei.gestion_orquestas.model.ClothType;
import com.gruposei.gestion_orquestas.repositories.ClothRepository;
import com.gruposei.gestion_orquestas.repositories.ClothTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothTypeService {

    @Autowired
    private ClothTypeRepository clothTypeRepository;

    public ClothType create(ClothType p){

        return clothTypeRepository.save(p);
    }

    public List<ClothType> getAll(){

        return clothTypeRepository.findAll();
    }

    public void delete(ClothType p){

        clothTypeRepository.delete(p);
    }

    public void deleteById(Long id){

        clothTypeRepository.deleteById(id);
    }

    public Optional<ClothType> findById(Long id){

        return clothTypeRepository.findById(id);
    }
}
