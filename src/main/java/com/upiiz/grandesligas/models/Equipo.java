package com.upiiz.grandesligas.models;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Data
@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String estadio;


    @ManyToOne
    @JoinColumn(name = "liga_id")
    private Liga liga;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Jugador> jugadores;

    @OneToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;
}