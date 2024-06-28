package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Habitacion;
import com.eoi.grupo5.repos.RepoHab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabSrvcImpl implements Servicio<Habitacion> {

    @Autowired
    private RepoHab habitacionRepository;

    @Override
    public List<Habitacion> listar() {
        return habitacionRepository.findAll();
    }

    @Override
    public Optional<Habitacion> porId(Integer id) {
        return habitacionRepository.findById(id);
    }

    @Override
    public void guardar(Habitacion entity) {
        habitacionRepository.save(entity);
    }

    @Override
    public void eliminar(Habitacion entity) {
        habitacionRepository.delete(entity);
    }
}
