package com.example.Actividad.enity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conductorId")
    private Long conductorId;

    @Column(name = "nombreConductor", nullable = false)
    private String nombreConductor;

    @Column(name = "licenciaConductor", nullable = false)
    private String licenciaConductor;

    @Column(name = "telefonoConductor", nullable = false)
    private String telefonoConductor;

    @Column(name = "direccionConductor", nullable = false)
    private String direccionConductor;

    @Enumerated(EnumType.STRING)
    @Column(name = "conductor_state", nullable = false)
    private ConductorState conductorState;

    @OneToOne
    @JoinColumn(name = "vehiculoId", referencedColumnName = "vehiculoId", nullable = false)
    private Vehiculo vehiculo;
}
