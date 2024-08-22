package com.gruposei.gestion_orquestas.repositories;

import com.gruposei.gestion_orquestas.model.ClothScale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClothScaleRepository extends JpaRepository<ClothScale,Long> {

    void deleteById(Long id);

    Optional<ClothScale> findBySize(String size);

    boolean existsBySize(String size);
}
