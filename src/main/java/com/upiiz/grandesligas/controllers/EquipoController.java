package com.upiiz.grandesligas.controllers;

import com.upiiz.grandesligas.models.Equipo;
import com.upiiz.grandesligas.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<Equipo> getAll() {
        return equipoService.findAll();
    }

    @GetMapping("/{id}")
    public Equipo getById(@PathVariable Long id) {
        return equipoService.findById(id);
    }

    @PostMapping
    public Equipo create(@RequestBody Equipo equipo) {
        return equipoService.save(equipo);
    }

    @PutMapping("/{id}")
    public Equipo update(@PathVariable Long id, @RequestBody Equipo equipo) {
        return equipoService.update(id, equipo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        equipoService.delete(id);
    }
}