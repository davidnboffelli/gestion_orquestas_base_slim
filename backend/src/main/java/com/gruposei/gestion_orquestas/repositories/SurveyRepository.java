package com.gruposei.gestion_orquestas.repositories;

import com.gruposei.gestion_orquestas.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey,Long> {

    void deleteById(Long id);
}
