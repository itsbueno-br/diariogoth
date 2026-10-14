package com.gotico.diario.repository;

import com.gotico.diario.model.Poesia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PoesiaRepository extends JpaRepository<Poesia, Long> {

    @Query(value = "SELECT * FROM poesias WHERE tipo = :tipo ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Poesia buscarAleatoriaPorTipo(@Param("tipo") String tipo);
}