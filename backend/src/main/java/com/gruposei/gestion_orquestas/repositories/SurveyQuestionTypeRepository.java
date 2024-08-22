package com.gruposei.gestion_orquestas.repositories;

import com.gruposei.gestion_orquestas.model.SurveyQuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyQuestionTypeRepository extends JpaRepository<SurveyQuestionType,Long> {

    void deleteById(Long id);
}
