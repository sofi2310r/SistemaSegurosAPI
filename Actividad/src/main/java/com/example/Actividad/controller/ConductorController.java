package com.example.Actividad.controller;

import com.example.Actividad.enity.Conductor;
import com.example.Actividad.service.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductor")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @PostMapping("/register")
    public ResponseEntity<?> registerConductor(@RequestBody Conductor conductor) {
        Conductor newConductor = conductorService.registerConductor(conductor);
        return ResponseEntity.status(HttpStatus.CREATED).body(newConductor);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Conductor>> listConductor() {
        List<Conductor> conductors = conductorService.listConductor();
        return ResponseEntity.ok(conductors);
    }

    @PutMapping("/update/{conductorId}")
    public ResponseEntity<?> updateConductor(@PathVariable Long conductorId, @RequestBody Conductor conductor) {
        try {
            Conductor updateConductor = new Conductor();
            updateConductor.setNombreConductor(conductor.getNombreConductor());
            updateConductor.setLicenciaConductor(conductor.getLicenciaConductor());
            updateConductor.setTelefonoConductor(conductor.getTelefonoConductor());
            updateConductor.setDireccionConductor(conductor.getDireccionConductor());
            updateConductor.setConductorState(conductor.getConductorState());
            updateConductor.setVehiculo(conductor.getVehiculo());

            Conductor conductorDB = conductorService.updateConductor(conductorId, updateConductor);
            return ResponseEntity.ok(conductorDB);
        }catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{conductorId}")
    public ResponseEntity<?> deleteConductor(@PathVariable Long conductorId) {
        try {
            conductorService.deleteConductor(conductorId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
