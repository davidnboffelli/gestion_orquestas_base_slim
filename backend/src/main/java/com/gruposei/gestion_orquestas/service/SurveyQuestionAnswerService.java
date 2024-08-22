package com.gruposei.gestion_orquestas.service;

import com.gruposei.gestion_orquestas.model.SurveyQuestionAnswer;
import com.gruposei.gestion_orquestas.model.SurveyQuestionAnswerKey;
import com.gruposei.gestion_orquestas.model.SurveyQuestionOptionAnswer;
import com.gruposei.gestion_orquestas.model.SurveyQuestionOptionAnswerKey;
import com.gruposei.gestion_orquestas.repositories.SurveyQuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyQuestionAnswerService {

    @Autowired
    private SurveyQuestionAnswerRepository surveyQuestionAnswerRepository;

    public SurveyQuestionAnswer create(SurveyQuestionAnswer p){

        return surveyQuestionAnswerRepository.save(p);
    }

    public List<SurveyQuestionAnswer> getAll(){

        return surveyQuestionAnswerRepository.findAll();
    }

    public void delete(SurveyQuestionAnswer p){

        surveyQuestionAnswerRepository.delete(p);
    }

    @Transactional
    public void deleteById(SurveyQuestionAnswerKey id){

        surveyQuestionAnswerRepository.deleteById(id);
    }

    public Optional<SurveyQuestionAnswer> findById(SurveyQuestionAnswerKey id){

        return surveyQuestionAnswerRepository.findById(id);
    }
}
