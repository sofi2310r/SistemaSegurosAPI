package com.example.Actividad.repository;

import com.example.Actividad.enity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    Optional<Conductor> findByConductorId(Long carroId);
}
