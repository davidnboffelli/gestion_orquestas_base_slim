package com.gruposei.gestion_orquestas.repositories;

import com.gruposei.gestion_orquestas.model.SurveyQuestionAnswer;
import com.gruposei.gestion_orquestas.model.SurveyQuestionAnswerKey;
import com.gruposei.gestion_orquestas.model.SurveyQuestionOptionAnswer;
import com.gruposei.gestion_orquestas.model.SurveyQuestionOptionAnswerKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveyQuestionAnswerRepository extends JpaRepository<SurveyQuestionAnswer,Long> {

    Optional<SurveyQuestionAnswer> findById(SurveyQuestionAnswerKey id);

    void deleteById(Long id);
    void deleteById(SurveyQuestionAnswerKey id);
}
