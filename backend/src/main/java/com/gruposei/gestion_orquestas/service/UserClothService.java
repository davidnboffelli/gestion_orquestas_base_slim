package com.gruposei.gestion_orquestas.service;

import com.gruposei.gestion_orquestas.model.SurveyQuestionAnswer;
import com.gruposei.gestion_orquestas.model.SurveyQuestionAnswerKey;
import com.gruposei.gestion_orquestas.model.UserCloth;
import com.gruposei.gestion_orquestas.model.UserClothKey;
import com.gruposei.gestion_orquestas.repositories.UserClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserClothService {

    @Autowired
    private UserClothRepository userClothRepository;

    public UserCloth create(UserCloth p){

        return userClothRepository.save(p);
    }

    public List<UserCloth> getAll(){

        return userClothRepository.findAll();
    }

    public void delete(UserCloth p){

        userClothRepository.delete(p);
    }

    @Transactional
    public void deleteById(UserClothKey id){

        userClothRepository.deleteById(id);
    }

    public Optional<UserCloth> findById(UserClothKey id){

        return userClothRepository.findById(id);
    }
}
