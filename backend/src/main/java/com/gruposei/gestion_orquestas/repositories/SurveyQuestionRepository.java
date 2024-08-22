package com.gruposei.gestion_orquestas.repositories;

import com.gruposei.gestion_orquestas.model.SurveyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyQuestionRepository extends JpaRepository<SurveyQuestion,Long> {

    void deleteById(Long id);
}
