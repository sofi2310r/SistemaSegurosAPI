package com.example.Actividad.service;

import com.example.Actividad.enity.Vehiculo;

import java.util.List;

public interface VehiculoService {
    Vehiculo registerVehiculo(Vehiculo vehiculo);

    List<Vehiculo> listVehiculo();

    Vehiculo updateVehiculo(Long vehiculoId, Vehiculo vehiculo) throws Exception;

    void deleteVehiculo(Long vehiculoId);
}
