package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Pago;
import com.eoi.grupo5.repos.RepoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoSrvcImpl implements Servicio<Pago>{

    @Autowired
    private RepoPago pagoRepository;

    @Override
    public List<Pago> listar() {
        return pagoRepository.findAll();
    }

    @Override
    public Optional<Pago> porId(Integer id) {
        return pagoRepository.findById(id);
    }

    @Override
    public void guardar(Pago entity) {
        pagoRepository.save(entity);
    }

    @Override
    public void eliminar(Pago entity) {
        pagoRepository.delete(entity);
    }
}
