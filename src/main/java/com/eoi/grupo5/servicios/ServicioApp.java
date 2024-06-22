package com.eoi.grupo5.servicios;

import com.eoi.grupo5.models.Habitacion;
import com.eoi.grupo5.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface ServicioApp {
    List<Usuario> listaUsuario();
    Optional<Usuario> usuarioporId(Integer id);
    void guardarUsuario(Usuario usu);
    void eliminarUsuario(Integer id);

    List<Habitacion> listaHabitacion();
    Optional<Habitacion> habitacionporId(Integer id);
    void guardarHabitacon(Habitacion habitacion);
    void eliminarHabitacion(Integer id);
}
