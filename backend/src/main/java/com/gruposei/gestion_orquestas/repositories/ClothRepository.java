package com.gruposei.gestion_orquestas.repositories;

import com.gruposei.gestion_orquestas.model.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothRepository extends JpaRepository<Cloth,Long> {

    void deleteById(Long id);
}
