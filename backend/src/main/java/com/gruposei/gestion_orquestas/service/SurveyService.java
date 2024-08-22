package com.gruposei.gestion_orquestas.service;

import com.gruposei.gestion_orquestas.model.Survey;
import com.gruposei.gestion_orquestas.repositories.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public Survey create(Survey p){

        return surveyRepository.save(p);
    }

    public List<Survey> getAll(){

        return surveyRepository.findAll();
    }

    public void delete(Survey p){

        surveyRepository.delete(p);
    }

    public void deleteById(Long id){

        surveyRepository.deleteById(id);
    }

    public Optional<Survey> findById(Long id){

        return surveyRepository.findById(id);
    }
}
