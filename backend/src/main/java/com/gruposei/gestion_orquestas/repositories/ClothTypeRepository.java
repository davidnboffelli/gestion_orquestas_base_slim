package com.gruposei.gestion_orquestas.repositories;

import com.gruposei.gestion_orquestas.model.ClothType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothTypeRepository extends JpaRepository<ClothType,Long> {

    void deleteById(Long id);
}
