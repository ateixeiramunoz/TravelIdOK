package com.eoi.grupo5.servicios;

import com.eoi.grupo5.models.Habitacion;
import com.eoi.grupo5.models.Usuario;
import com.eoi.grupo5.repos.HabitacionRepoImpl;
import com.eoi.grupo5.repos.Repo;
import com.eoi.grupo5.repos.UsuarioRepoImpl;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ServicioAppImpl implements ServicioApp{

    private Repo<Usuario> repoUsu;
    private Repo<Habitacion> repoHab;

    public ServicioAppImpl(EntityManager em){
        this.repoUsu = new UsuarioRepoImpl(em);
        this.repoHab = new HabitacionRepoImpl(em);
    }


    @Override
    public List<Usuario> listaUsuario() {
        return repoUsu.listar();
    }

    @Override
    public Optional<Usuario> usuarioporId(Integer id) {
        return repoUsu.porId(id);
    }

    @Override
    public void guardarUsuario(Usuario usu) {
        repoUsu.guardar(usu);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        repoUsu.eliminar(id);
    }

    @Override
    public List<Habitacion> listaHabitacion() {
        return repoHab.listar();
    }

    @Override
    public Optional<Habitacion> habitacionporId(Integer id) {
        return repoHab.porId(id);
    }

    @Override
    public void guardarHabitacon(Habitacion habitacion) {
        repoHab.guardar(habitacion);    }

    @Override
    public void eliminarHabitacion(Integer id) {
        repoHab.eliminar(id);
    }

}
