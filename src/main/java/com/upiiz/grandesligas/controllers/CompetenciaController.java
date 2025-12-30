package com.upiiz.grandesligas.controllers;

import com.upiiz.grandesligas.models.Competencia;
import com.upiiz.grandesligas.services.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/competencias")
public class CompetenciaController {

    @Autowired
    private CompetenciaService competenciaService;

    @GetMapping
    public List<Competencia> getAll() {
        return competenciaService.findAll();
    }

    @GetMapping("/{id}")
    public Competencia getById(@PathVariable Long id) {
        return competenciaService.findById(id);
    }

    @PostMapping
    public Competencia create(@RequestBody Competencia competencia) {
        return competenciaService.save(competencia);
    }

    @PutMapping("/{id}")
    public Competencia update(@PathVariable Long id, @RequestBody Competencia competencia) {
        return competenciaService.update(id, competencia);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        competenciaService.delete(id);
    }
}