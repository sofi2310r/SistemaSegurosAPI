package com.example.Actividad.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehiculoid")
    private Long vehiculoId;

    @Column(name = "vehiculoplaca", nullable = false)
    private String vehiculoPlaca;

    @Column(name = "vehiculomarca", nullable = false, length = 100)
    private String vehicuMarca;

    @Column(name = "vehiculomodelo", nullable = false, length = 100)
    private String vehiculoModelo;

    @Column(name = "vehiculoyear", nullable = false)
    private Integer vehiculoYear;

    @Column(name = "vehiculocolor", nullable = false, length = 100)
    private String vehiculoColor;

}
