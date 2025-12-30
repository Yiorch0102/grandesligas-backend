package com.upiiz.grandesligas.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "entrenadores")
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String nacionalidad;


}