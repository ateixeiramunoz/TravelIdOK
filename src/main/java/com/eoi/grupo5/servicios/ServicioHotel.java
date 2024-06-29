package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Hotel;
import com.eoi.grupo5.repos.RepoHotel;
import org.springframework.stereotype.Service;

@Service
public class ServicioHotel extends AbstractBusinessServiceSoloEnt<Hotel, Integer, RepoHotel>{

    protected ServicioHotel(RepoHotel repoHotel) {
        super(repoHotel);
    }
}
