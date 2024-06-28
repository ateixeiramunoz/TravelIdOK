package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Asiento;
import com.eoi.grupo5.repos.RepoAsiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsientoSrvcImpl implements Servicio<Asiento>{

    @Autowired
    private RepoAsiento asientoRepository;

    @Override
    public List<Asiento> listar() {
        return asientoRepository.findAll();
    }

    @Override
    public Optional<Asiento> porId(Integer id) {
        return asientoRepository.findById(id);
    }

    @Override
    public void guardar(Asiento entity) {
        asientoRepository.save(entity);
    }

    @Override
    public void eliminar(Asiento entity) {
        asientoRepository.delete(entity);
    }
}
