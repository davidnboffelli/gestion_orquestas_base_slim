package com.gruposei.gestion_orquestas.service;

import com.gruposei.gestion_orquestas.model.Survey;
import com.gruposei.gestion_orquestas.model.SurveyQuestion;
import com.gruposei.gestion_orquestas.repositories.SurveyQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyQuestionService {

    @Autowired
    private SurveyQuestionRepository surveyQuestionRepository;

    public SurveyQuestion create(SurveyQuestion p){

        return surveyQuestionRepository.save(p);
    }

    public List<SurveyQuestion> getAll(){

        return surveyQuestionRepository.findAll();
    }

    public void delete(SurveyQuestion p){

        surveyQuestionRepository.delete(p);
    }

    public void deleteById(Long id){

        surveyQuestionRepository.deleteById(id);
    }

    public Optional<SurveyQuestion> findById(Long id){

        return surveyQuestionRepository.findById(id);
    }
}
