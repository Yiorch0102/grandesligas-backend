package com.upiiz.grandesligas.services;

import com.upiiz.grandesligas.models.Competencia;
import com.upiiz.grandesligas.repositories.CompetenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompetenciaService {

    @Autowired
    private CompetenciaRepository competenciaRepository;

    public List<Competencia> findAll() {
        return competenciaRepository.findAll();
    }

    public Competencia findById(Long id) {
        return competenciaRepository.findById(id).orElse(null);
    }

    public Competencia save(Competencia competencia) {
        return competenciaRepository.save(competencia);
    }

    public Competencia update(Long id, Competencia competencia) {
        Competencia compActual = competenciaRepository.findById(id).orElse(null);
        if (compActual != null) {
            compActual.setNombre(competencia.getNombre());
            compActual.setFechaInicio(competencia.getFechaInicio());
            compActual.setFechaFin(competencia.getFechaFin());
            compActual.setMarcador(competencia.getMarcador());
            compActual.setEquipoLocal(competencia.getEquipoLocal());
            compActual.setEquipoVisitante(competencia.getEquipoVisitante());
            return competenciaRepository.save(compActual);
        }
        return null;
    }

    public void delete(Long id) {
        competenciaRepository.deleteById(id);
    }
}