package com.eoi.grupo5.servicios;

import com.eoi.grupo5.models.*;
import com.eoi.grupo5.repos.*;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ServicioAppImpl implements ServicioApp{

    private Repo<Usuario> repoUsu;
    private Repo<Actividad> repoAct;
    private Repo<Asiento> repoAsi;
    private Repo<Habitacion> repoHab;
    private Repo<Pago> repoPago;
    private Repo<Reserva> repoReserv;

    public ServicioAppImpl(EntityManager em){
        this.repoUsu = new UsuarioRepoImpl(em);
        this.repoAct  = new ActividadRepoImpl(em);
        this.repoAsi  = new AsientoRepoImpl(em);
        this.repoHab  = new HabitacionRepoImpl(em);
        this.repoPago  = new PagoRepoImpl(em);
        this.repoReserv = new ReservaRepoImpl(em);
    }

    // Usuario

    @Override
    public List<Usuario> listarUsuarios() {
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

    // Actividad

    @Override
    public List<Actividad> listarActividades() {
        return repoAct.listar();
    }

    @Override
    public Optional<Actividad> actividadporId(Integer id) {
        return repoAct.porId(id);
    }

    @Override
    public void guardarActividad(Actividad act) {
        repoAct.guardar(act);
    }

    @Override
    public void eliminarActividad(Integer id) {
        repoAct.eliminar(id);
    }

    // Asiento

    @Override
    public List<Asiento> listarAsientos() {
        return repoAsi.listar();
    }

    @Override
    public Optional<Asiento> asientoporId(Integer id) {
        return repoAsi.porId(id);
    }

    @Override
    public void guardarAsiento(Asiento asi) {
        repoAsi.guardar(asi);
    }

    @Override
    public void eliminarAsiento(Integer id) {
        repoAsi.eliminar(id);
    }

    // Habitación

    @Override
    public List<Habitacion> listarHabitaciones() {
        return repoHab.listar();
    }

    @Override
    public Optional<Habitacion> habitacionporId(Integer id) {
        return repoHab.porId(id);
    }

    @Override
    public void guardarHabitacion(Habitacion habitacion) {
        repoHab.guardar(habitacion);
    }

    @Override
    public void eliminarHabitacion(Integer id) {
        repoHab.eliminar(id);
    }

    // Pago

    @Override
    public List<Pago> listarPagos() {
        return repoPago.listar();
    }

    @Override
    public Optional<Pago> pagoporId(Integer id) {
        return repoPago.porId(id);
    }

    @Override
    public void guardarPago(Pago pago) {
        repoPago.guardar(pago);
    }

    @Override
    public void eliminarPago(Integer id) {
        repoPago.eliminar(id);
    }

    // Reserva

    @Override
    public List<Reserva> listarReservas() {
        return repoReserv.listar();
    }

    @Override
    public Optional<Reserva> reservaporId(Integer id) {
        return repoReserv.porId(id);
    }

    @Override
    public void guardarReserva(Reserva reserva) {
        repoReserv.guardar(reserva);
    }

    @Override
    public void eliminarReserva(Integer id) {
        repoReserv.eliminar(id);
    }

}
