package com.upiiz.grandesligas.controllers;

import com.upiiz.grandesligas.models.Liga;
import com.upiiz.grandesligas.services.LigaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ligas")
public class LigaController {

    @Autowired
    private LigaService ligaService;

    @GetMapping
    public List<Liga> getAll() {
        return ligaService.findAll();
    }

    @GetMapping("/{id}")
    public Liga getById(@PathVariable Long id) {
        return ligaService.findById(id);
    }

    @PostMapping
    public Liga create(@RequestBody Liga liga) {
        return ligaService.save(liga);
    }

    @PutMapping("/{id}")
    public Liga update(@PathVariable Long id, @RequestBody Liga liga) {
        return ligaService.update(id, liga);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ligaService.delete(id);
    }
}