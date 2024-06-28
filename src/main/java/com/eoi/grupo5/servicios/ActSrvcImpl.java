package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Actividad;
import com.eoi.grupo5.repos.RepoActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActSrvcImpl implements Servicio<Actividad> {

    @Autowired
    private RepoActividad actividadRepository;

    @Override
    public List<Actividad> listar() {
        return actividadRepository.findAll();
    }

    @Override
    public Optional<Actividad> porId(Integer id) {
        return actividadRepository.findById(id);
    }

    @Override
    public void guardar(Actividad entity) {
        actividadRepository.save(entity);
    }

    @Override
    public void eliminar(Actividad entity) {
        actividadRepository.delete(entity);
    }
}
