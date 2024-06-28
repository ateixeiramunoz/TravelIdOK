package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Habitacion;
import com.eoi.grupo5.repos.RepoHabitacion;
import org.springframework.stereotype.Service;

@Service
public class ServicioHabitacion extends AbstractBusinessServiceSoloEnt<Habitacion, Integer, RepoHabitacion>{

    protected ServicioHabitacion(RepoHabitacion repoHabitacion) {
        super(repoHabitacion);
    }
}
