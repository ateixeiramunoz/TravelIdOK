package com.eoi.grupo5.servicios;

import com.eoi.grupo5.models.*;

import java.util.List;
import java.util.Optional;

public interface ServicioApp {

    List<Usuario> listarUsuarios();
    Optional<Usuario> usuarioporId(Integer id);
    void guardarUsuario(Usuario usu);
    void eliminarUsuario(Integer id);

    List<Actividad> listarActividades();
    Optional<Actividad> actividadporId(Integer id);
    void guardarActividad(Actividad act);
    void eliminarActividad(Integer id);

    List<Asiento> listarAsientos();
    Optional<Asiento> asientoporId(Integer id);
    void guardarAsiento(Asiento asi);
    void eliminarAsiento(Integer id);

    List<Habitacion> listarHabitaciones();
    Optional<Habitacion> habitacionporId(Integer id);
    void guardarHabitacion(Habitacion habitacion);
    void eliminarHabitacion(Integer id);

    List<Pago> listarPagos();
    Optional<Pago> pagoporId(Integer id);
    void guardarPago(Pago pago);
    void eliminarPago(Integer id);

    List<Reserva> listarReservas();
    Optional<Reserva> reservaporId(Integer id);
    void guardarReserva(Reserva reserva);
    void eliminarReserva(Integer id);
}
