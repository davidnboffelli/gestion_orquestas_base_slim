package com.gruposei.gestion_orquestas.repositories;

import com.gruposei.gestion_orquestas.model.SurveyQuestionOptionAnswer;
import com.gruposei.gestion_orquestas.model.SurveyQuestionOptionAnswerKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveyQuestionOptionAnswerRepository extends JpaRepository<SurveyQuestionOptionAnswer,Long> {

    Optional<SurveyQuestionOptionAnswer> findById(SurveyQuestionOptionAnswerKey id);

    void deleteById(Long id);
    void deleteById(SurveyQuestionOptionAnswerKey id);
}
