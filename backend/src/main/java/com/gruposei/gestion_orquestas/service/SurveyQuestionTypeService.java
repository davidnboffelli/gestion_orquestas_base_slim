package com.gruposei.gestion_orquestas.service;

import com.gruposei.gestion_orquestas.model.Survey;
import com.gruposei.gestion_orquestas.model.SurveyQuestionType;
import com.gruposei.gestion_orquestas.repositories.SurveyQuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyQuestionTypeService {

    @Autowired
    private SurveyQuestionTypeRepository surveyQuestionTypeRepository;

    public SurveyQuestionType create(SurveyQuestionType p){

        return surveyQuestionTypeRepository.save(p);
    }

    public List<SurveyQuestionType> getAll(){

        return surveyQuestionTypeRepository.findAll();
    }

    public void delete(SurveyQuestionType p){

        surveyQuestionTypeRepository.delete(p);
    }

    public void deleteById(Long id){

        surveyQuestionTypeRepository.deleteById(id);
    }

    public Optional<SurveyQuestionType> findById(Long id){

        return surveyQuestionTypeRepository.findById(id);
    }
}
