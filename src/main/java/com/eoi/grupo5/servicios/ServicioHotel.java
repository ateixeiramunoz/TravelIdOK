package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Hotel;
import com.eoi.grupo5.repos.RepoHotel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ServicioHotel extends AbstractBusinessServiceSoloEnt<Hotel, Integer, RepoHotel>{

    protected ServicioHotel(RepoHotel repoHotel) {
        super(repoHotel);
    }

    public List<Hotel> obtenerHotelesEnTuZona(Hotel hotel) {
        return super
                .buscarEntidades()
                .stream()
                .filter(h -> h.getLocalizacion() == hotel.getLocalizacion() && !Objects.equals(h.getId(), hotel.getId())).limit(2)
                .toList();
    }


}
