package com.gruposei.gestion_orquestas.repositories;

import com.gruposei.gestion_orquestas.model.UserCloth;
import com.gruposei.gestion_orquestas.model.UserClothKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserClothRepository extends JpaRepository<UserCloth,Long> {

    Optional<UserCloth> findById(UserClothKey id);

    void deleteById(UserClothKey id);
    void deleteById(Long id);
}
