package com.example.Actividad.service.implementacion;

import com.example.Actividad.enity.Conductor;
import com.example.Actividad.repository.ConductorRepository;
import com.example.Actividad.service.ConductorService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public Conductor registerConductor(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    @Override
    public List<Conductor> listConductor() {
        return conductorRepository.findAll();
    }

    @Override
    public Conductor updateConductor(Long conductorId, Conductor conductor) throws Exception {
        Conductor conductorExisting = conductorRepository.findByConductorId(conductorId)
                .orElseThrow(() -> new Exception("Conductor con el ID " + conductorId + " no encontrado"));

        conductorExisting.setNombreConductor(conductor.getNombreConductor());
        conductorExisting.setLicenciaConductor(conductor.getLicenciaConductor());
        conductorExisting.setTelefonoConductor(conductor.getTelefonoConductor());
        conductorExisting.setDireccionConductor(conductor.getDireccionConductor());
        conductorExisting.setConductorState(conductor.getConductorState());
        conductorExisting.setVehiculo(conductor.getVehiculo());

        return conductorRepository.save(conductorExisting);
    }

    @SneakyThrows
    @Override
    public void deleteConductor(Long conductorId) {
        Conductor conductorExsisting = conductorRepository.findByConductorId(conductorId)
                .orElseThrow(() -> new Exception("Conductor con el Id " + conductorId + " no encontrado"));
        conductorRepository.deleteById(conductorExsisting.getConductorId());
    }
}
