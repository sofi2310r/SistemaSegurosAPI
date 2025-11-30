package com.example.Actividad.service;

import com.example.Actividad.enity.Conductor;

import java.util.List;

public interface ConductorService {

    Conductor registerConductor(Conductor conductor);

    List<Conductor> listConductor();

    Conductor updateConductor(Long conductorId, Conductor conductor) throws Exception;

    void deleteConductor(Long conductorId);
}
