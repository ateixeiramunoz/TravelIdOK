package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Reserva;
import com.eoi.grupo5.repos.RepoReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaSrvcImpl implements Servicio<Reserva>{

    @Autowired
    private RepoReserva reservaRepository;

    @Override
    public List<Reserva> listar() {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> porId(Integer id) {
        return reservaRepository.findById(id);
    }

    @Override
    public void guardar(Reserva entity) {
        reservaRepository.save(entity);
    }

    @Override
    public void eliminar(Reserva entity) {
        reservaRepository.delete(entity);
    }
}
