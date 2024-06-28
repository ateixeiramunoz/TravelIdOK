package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Usuario;
import com.eoi.grupo5.repos.RepoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioSrvcImpl implements Servicio<Usuario> {

    @Autowired
    private RepoUsuario usuarioRepository;

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> porId(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public void guardar(Usuario entity) {
        usuarioRepository.save(entity);
    }

    @Override
    public void eliminar(Usuario entity) {
        usuarioRepository.delete(entity);
    }
}
