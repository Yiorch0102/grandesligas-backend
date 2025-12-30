package com.upiiz.grandesligas.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private int edad;

    private String posicion;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;
}