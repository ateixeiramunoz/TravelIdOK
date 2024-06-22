package com.eoi.grupo5.servicios;


import com.eoi.grupo5.models.Usuario;
import com.eoi.grupo5.repos.Repo;
import com.eoi.grupo5.repos.UsuarioRepoImpl;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ServicioAppImpl implements ServicioApp{

    private Repo<Usuario> repoUsu;
    public ServicioAppImpl(EntityManager em){this.repoUsu = new UsuarioRepoImpl(em);}


    @Override
    public List<Usuario> listaUsuario() {
        return repoUsu.listar();
    }

    @Override
    public Optional<Usuario> porId(Integer id) {
        return repoUsu.porId(id);
    }

    @Override
    public void guardar(Usuario usu) {
        repoUsu.guardar(usu);
    }

    @Override
    public void eliminar(Integer id) {
        repoUsu.eliminar(id);
    }

}
