package com.upiiz.grandesligas.controllers;

import com.upiiz.grandesligas.models.Entrenador;
import com.upiiz.grandesligas.services.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping
    public List<Entrenador> getAll() {
        return entrenadorService.findAll();
    }

    @GetMapping("/{id}")
    public Entrenador getById(@PathVariable Long id) {
        return entrenadorService.findById(id);
    }

    @PostMapping
    public Entrenador create(@RequestBody Entrenador entrenador) {
        return entrenadorService.save(entrenador);
    }

    @PutMapping("/{id}")
    public Entrenador update(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        return entrenadorService.update(id, entrenador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        entrenadorService.delete(id);
    }
}