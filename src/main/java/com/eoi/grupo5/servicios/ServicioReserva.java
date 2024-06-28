package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Reserva;
import com.eoi.grupo5.repos.RepoReserva;
import org.springframework.stereotype.Service;

@Service
public class ServicioReserva extends AbstractBusinessServiceSoloEnt<Reserva, Integer, RepoReserva>{

    protected ServicioReserva(RepoReserva repoReserva) {
        super(repoReserva);
    }
}
