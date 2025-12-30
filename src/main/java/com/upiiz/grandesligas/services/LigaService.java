package com.upiiz.grandesligas.services;

import com.upiiz.grandesligas.models.Liga;
import com.upiiz.grandesligas.repositories.LigaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LigaService {

    @Autowired
    private LigaRepository ligaRepository;

    public List<Liga> findAll() {
        return ligaRepository.findAll();
    }

    public Liga findById(Long id) {
        return ligaRepository.findById(id).orElse(null);
    }

    public Liga save(Liga liga) {
        return ligaRepository.save(liga);
    }

    public Liga update(Long id, Liga liga) {
        Liga ligaActual = ligaRepository.findById(id).orElse(null);
        if (ligaActual != null) {
            ligaActual.setNombre(liga.getNombre());
            ligaActual.setPais(liga.getPais());
            ligaActual.setPresidente(liga.getPresidente());
            return ligaRepository.save(ligaActual);
        }
        return null;
    }

    public void delete(Long id) {
        ligaRepository.deleteById(id);
    }
}