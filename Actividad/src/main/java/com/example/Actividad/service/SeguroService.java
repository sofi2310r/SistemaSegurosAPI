package com.example.Actividad.service;

import com.example.Actividad.enity.Seguro;

import java.util.List;

public interface SeguroService {

    Seguro registerSeguro(Seguro seguro);

    List<Seguro> listSeguro();

    Seguro updateSeguro(Long seguroId, Seguro seguro) throws Exception;

    void deleteSeuro(Long seguroId);

    List<Seguro> listSeguroByVehiculo(Long vehiculoId);
}
