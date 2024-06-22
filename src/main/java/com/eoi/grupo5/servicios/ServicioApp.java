package com.eoi.grupo5.servicios;

import com.eoi.grupo5.models.Actividad;
import com.eoi.grupo5.models.Asiento;
import com.eoi.grupo5.models.Habitacion;
import com.eoi.grupo5.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface ServicioApp {
    List<Usuario> listaUsuario();
    Optional<Usuario> usuarioporId(Integer id);
    void guardarUsuario(Usuario usu);
    void eliminarUsuario(Integer id);

    List<Actividad> listaActividad();
    Optional<Actividad> actividadporId(Integer id);
    void guardarActividad(Actividad act);
    void eliminarActividad(Integer id);

    List<Asiento> listaAsiento();
    Optional<Asiento> asientoporId(Integer id);
    void guardarAsiento(Asiento asi);
    void eliminarAsiento(Integer id);

    List<Habitacion> listaHabitacion();
    Optional<Habitacion> habitacionporId(Integer id);
    void guardarHabitacon(Habitacion habitacion);
    void eliminarHabitacion(Integer id);
}
