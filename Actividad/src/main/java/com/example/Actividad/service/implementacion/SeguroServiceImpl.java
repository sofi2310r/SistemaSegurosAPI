package com.example.Actividad.service.implementacion;

import com.example.Actividad.enity.Seguro;
import com.example.Actividad.repository.SeguroRepository;
import com.example.Actividad.service.SeguroService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguroServiceImpl implements SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    @Override
    public Seguro registerSeguro(Seguro seguro) {
        return seguroRepository.save(seguro);
    }

    @Override
    public List<Seguro> listSeguro() {
        return seguroRepository.findAll();
    }

    @Override
    public Seguro updateSeguro(Long seguroId, Seguro seguro) throws Exception {
        Seguro seguroExisting = seguroRepository.findBySeguroId(seguroId)
                .orElseThrow(() -> new Exception("Seguro con el Id " + seguroId + " no  encontrado"));

        seguroExisting.setCompañia(seguro.getCompañia());
        seguroExisting.setNumeroPoliza(seguro.getNumeroPoliza());
        seguroExisting.setFechaInicio(seguro.getFechaInicio());
        seguroExisting.setFechaVencimiento(seguro.getFechaVencimiento());
        seguroExisting.setVehiculo(seguro.getVehiculo());

        return seguroRepository.save(seguroExisting);
    }

@SneakyThrows
    @Override
    public void deleteSeuro(Long seguroId) {
        Seguro seguroExisting = seguroRepository.findBySeguroId(seguroId)
                .orElseThrow(() -> new Exception("Seguro con el Id " + seguroId + " no encontrado"));

        seguroRepository.deleteById(seguroExisting.getSeguroId());
    }

    @Override
    public List<Seguro> listSeguroByVehiculo(Long vehiculoId) {
        return seguroRepository.findByVehiculoVehiculoId(vehiculoId);
    }
}
