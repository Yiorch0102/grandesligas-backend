package com.upiiz.grandesligas.controllers;

import com.upiiz.grandesligas.models.Jugador;
import com.upiiz.grandesligas.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> getAll() {
        return jugadorService.findAll();
    }

    @GetMapping("/{id}")
    public Jugador getById(@PathVariable Long id) {
        return jugadorService.findById(id);
    }

    @PostMapping
    public Jugador create(@RequestBody Jugador jugador) {
        return jugadorService.save(jugador);
    }

    @PutMapping("/{id}")
    public Jugador update(@PathVariable Long id, @RequestBody Jugador jugador) {
        return jugadorService.update(id, jugador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        jugadorService.delete(id);
    }
}