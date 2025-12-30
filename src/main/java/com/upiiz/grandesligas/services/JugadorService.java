package com.upiiz.grandesligas.services;

import com.upiiz.grandesligas.models.Jugador;
import com.upiiz.grandesligas.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    public Jugador findById(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    public Jugador save(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Jugador update(Long id, Jugador jugador) {
        Jugador jugadorActual = jugadorRepository.findById(id).orElse(null);
        if (jugadorActual != null) {
            jugadorActual.setNombre(jugador.getNombre());
            jugadorActual.setEdad(jugador.getEdad());
            jugadorActual.setPosicion(jugador.getPosicion());
            jugadorActual.setEquipo(jugador.getEquipo());
            return jugadorRepository.save(jugadorActual);
        }
        return null;
    }

    public void delete(Long id) {
        jugadorRepository.deleteById(id);
    }
}