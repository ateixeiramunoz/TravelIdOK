package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Asiento;
import com.eoi.grupo5.repos.RepoAsiento;
import org.springframework.stereotype.Service;

@Service
public class ServicioAsiento extends AbstractBusinessServiceSoloEnt<Asiento, Integer, RepoAsiento>{

    protected ServicioAsiento(RepoAsiento repoAsiento) {
        super(repoAsiento);
    }
}
