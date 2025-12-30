package com.upiiz.grandesligas.services;

import com.upiiz.grandesligas.models.Entrenador;
import com.upiiz.grandesligas.repositories.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public List<Entrenador> findAll() {
        return entrenadorRepository.findAll();
    }

    public Entrenador findById(Long id) {
        return entrenadorRepository.findById(id).orElse(null);
    }

    public Entrenador save(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public Entrenador update(Long id, Entrenador entrenador) {
        Entrenador entrenadorActual = entrenadorRepository.findById(id).orElse(null);
        if (entrenadorActual != null) {
            entrenadorActual.setNombre(entrenador.getNombre());
            entrenadorActual.setNacionalidad(entrenador.getNacionalidad());

            // BORRAMOS LA LÍNEA DE setEquipo() PORQUE YA NO EXISTE ESA RELACIÓN AQUÍ
            // entrenadorActual.setEquipo(entrenador.getEquipo()); <--- ELIMINADO

            return entrenadorRepository.save(entrenadorActual);
        }
        return null;
    }

    public void delete(Long id) {
        entrenadorRepository.deleteById(id);
    }
}