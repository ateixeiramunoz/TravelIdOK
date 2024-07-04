package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Hotel;
import com.eoi.grupo5.repos.RepoHotel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ServicioHotel extends AbstractBusinessServiceSoloEnt<Hotel, Integer, RepoHotel>{

    protected ServicioHotel(RepoHotel repoHotel) {
        super(repoHotel);
    }

    public List<Hotel> obtenerHotelesEnTuZona(Optional<Hotel> hotel) {
        return super.buscarEntidades()
                .stream()
                .filter(h -> h.getLocalizacion().getNombre().equals(hotel.get().getLocalizacion().getNombre()) && h.getId() != hotel.get().getId())
                .limit(2)
                .toList();
    }


}
