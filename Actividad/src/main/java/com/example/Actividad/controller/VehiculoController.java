package com.example.Actividad.controller;

import com.example.Actividad.enity.Vehiculo;
import com.example.Actividad.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/register")
    public ResponseEntity<?> registerVehiculo(@RequestBody Vehiculo vehiculo) {
        Vehiculo newVehiculo = vehiculoService.registerVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVehiculo);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Vehiculo>> listVehiculo() {
        List<Vehiculo> vehiculos = vehiculoService.listVehiculo();
        return ResponseEntity.ok(vehiculos);
    }

    @PutMapping("/update/{vehiculoId}")
    public ResponseEntity<?> updateVehiculo(@PathVariable Long vehiculoId, @RequestBody Vehiculo vehiculo) {
        try {
            Vehiculo updateVehiculo = new Vehiculo();
            updateVehiculo.setVehiculoPlaca(vehiculo.getVehiculoPlaca());
            updateVehiculo.setVehicuMarca(vehiculo.getVehicuMarca());
            updateVehiculo.setVehiculoModelo(vehiculo.getVehiculoModelo());
            updateVehiculo.setVehiculoYear(vehiculo.getVehiculoYear());
            updateVehiculo.setVehiculoColor(vehiculo.getVehiculoColor());

            Vehiculo vehiculoDB = vehiculoService.updateVehiculo(vehiculoId, updateVehiculo);
            return ResponseEntity.ok(vehiculoDB);
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{vehiculoId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long vehiculoId) {
        try {
            vehiculoService.deleteVehiculo(vehiculoId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
