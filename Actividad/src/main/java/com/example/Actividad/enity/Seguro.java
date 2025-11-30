package com.example.Actividad.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seguroId", nullable = false)
    private Long seguroId;

    @ManyToOne
    @JoinColumn(name = "vehiculoId", referencedColumnName = "vehiculoId", nullable = false)
    private Vehiculo vehiculo;

    @Column(name = "compañia", nullable = false)
    private String compañia;

    @Column(name = "numeroPoliza", nullable = false)
    private String numeroPoliza;

    @Column(name = "fechaInicio", nullable = false)
    private String fechaInicio;

    @Column(name = "fechaVencimiento", nullable = false)
    private String fechaVencimiento;
}
