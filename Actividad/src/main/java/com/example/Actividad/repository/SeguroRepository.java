package com.example.Actividad.repository;

import com.example.Actividad.enity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {
    Optional<Seguro> findBySeguroId(Long seguroId);

    List<Seguro> findByVehiculoVehiculoId(Long vehiculoId);
}
