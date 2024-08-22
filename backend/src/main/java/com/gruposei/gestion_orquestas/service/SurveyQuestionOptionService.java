package com.gruposei.gestion_orquestas.service;

import com.gruposei.gestion_orquestas.model.SurveyQuestion;
import com.gruposei.gestion_orquestas.model.SurveyQuestionOption;
import com.gruposei.gestion_orquestas.repositories.SurveyQuestionOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyQuestionOptionService {

    @Autowired
    private SurveyQuestionOptionRepository surveyQuestionOptionRepository;

    public SurveyQuestionOption create(SurveyQuestionOption p){

        return surveyQuestionOptionRepository.save(p);
    }

    public List<SurveyQuestionOption> getAll(){

        return surveyQuestionOptionRepository.findAll();
    }

    public void delete(SurveyQuestionOption p){

        surveyQuestionOptionRepository.delete(p);
    }

    public void deleteById(Long id){

        surveyQuestionOptionRepository.deleteById(id);
    }

    public Optional<SurveyQuestionOption> findById(Long id){

        return surveyQuestionOptionRepository.findById(id);
    }
}
