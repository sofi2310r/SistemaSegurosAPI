package com.example.Actividad.controller;

import com.example.Actividad.enity.Seguro;
import com.example.Actividad.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguro")
public class SeguroController {

    @Autowired
    private SeguroService seguroService;

    @PostMapping("/register")
    public ResponseEntity<?> registerSeguro(@RequestBody Seguro seguro) {
        Seguro newSeguro = seguroService.registerSeguro(seguro);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSeguro);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Seguro>>  listSeguro() {
        List<Seguro> seguros = seguroService.listSeguro();
        return ResponseEntity.ok(seguros);
    }

    @PutMapping("/update/{seguroId}")
    public ResponseEntity<?> updateSeguro(@PathVariable Long seguroId, @RequestBody Seguro seguro) {
        try {
            Seguro updateSeguro = new Seguro();
            updateSeguro.setCompañia(seguro.getCompañia());
            updateSeguro.setNumeroPoliza(seguro.getNumeroPoliza());
            updateSeguro.setFechaInicio(seguro.getFechaInicio());
            updateSeguro.setFechaVencimiento(seguro.getFechaVencimiento());
            updateSeguro.setVehiculo(seguro.getVehiculo());

            Seguro seguroDB = seguroService.updateSeguro(seguroId, updateSeguro);
            return ResponseEntity.ok(seguroDB);
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{seguroId}")
    public ResponseEntity<?> deleteSeguro(@PathVariable Long seguroId) {
        try {
            seguroService.deleteSeuro(seguroId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @GetMapping("/list/vehiculo/{vehiculoId}")
    public  ResponseEntity<List<Seguro>> listSeguroByVehiculo(@PathVariable Long vehiculoId) {
        List<Seguro> seguros = seguroService.listSeguroByVehiculo(vehiculoId);
        return ResponseEntity.ok(seguros);
    }
}
