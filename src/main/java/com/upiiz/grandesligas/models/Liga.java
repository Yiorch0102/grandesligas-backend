package com.upiiz.grandesligas.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name = "ligas")
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    private String pais;

    private String presidente;

    @OneToMany(mappedBy = "liga", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Equipo> equipos;
}