package com.upiiz.grandesligas.services;

import com.upiiz.grandesligas.models.Equipo;
import com.upiiz.grandesligas.repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    public Equipo findById(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo update(Long id, Equipo equipo) {
        Equipo equipoActual = equipoRepository.findById(id).orElse(null);
        if (equipoActual != null) {
            equipoActual.setNombre(equipo.getNombre());
            equipoActual.setEstadio(equipo.getEstadio());
            equipoActual.setLiga(equipo.getLiga());
            return equipoRepository.save(equipoActual);
        }
        return null;
    }

    public void delete(Long id) {
        equipoRepository.deleteById(id);
    }
}