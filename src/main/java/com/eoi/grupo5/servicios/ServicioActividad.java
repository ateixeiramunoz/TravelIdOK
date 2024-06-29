package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Actividad;
import com.eoi.grupo5.repos.RepoActividad;
import org.springframework.stereotype.Service;

@Service
public class ServicioActividad extends AbstractBusinessServiceSoloEnt<Actividad, Integer, RepoActividad>{

    protected ServicioActividad(RepoActividad repoActividad) {
        super(repoActividad);
    }
}
