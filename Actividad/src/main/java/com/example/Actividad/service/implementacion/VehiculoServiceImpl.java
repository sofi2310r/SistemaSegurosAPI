package com.example.Actividad.service.implementacion;

import com.example.Actividad.enity.Vehiculo;
import com.example.Actividad.repository.VehiculoRepository;
import com.example.Actividad.service.VehiculoService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo registerVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> listVehiculo() {
        return vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo updateVehiculo(Long vehiculoId, Vehiculo vehiculo) throws Exception {
        Vehiculo vehiculoExisting = vehiculoRepository.findByVehiculoId(vehiculoId)
                .orElseThrow(()-> new Exception("Vehiculo con el ID " + vehiculoId + "no encontrado"));

        vehiculoExisting.setVehiculoPlaca(vehiculo.getVehiculoPlaca());
        vehiculoExisting.setVehicuMarca(vehiculo.getVehicuMarca());
        vehiculoExisting.setVehiculoModelo(vehiculo.getVehiculoModelo());
        vehiculoExisting.setVehiculoYear(vehiculo.getVehiculoYear());
        vehiculoExisting.setVehiculoColor(vehiculo.getVehiculoColor());

        return vehiculoRepository.save(vehiculoExisting);
    }

    @SneakyThrows
    @Override
    public void deleteVehiculo(Long vehiculoId) {
        Vehiculo vehiculoExisting = vehiculoRepository.findByVehiculoId(vehiculoId)
                .orElseThrow(()-> new Exception("Vehiculo con el ID " + vehiculoId + "no se encuentra"));
        vehiculoRepository.deleteById(vehiculoId);
    }
}
