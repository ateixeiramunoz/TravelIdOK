package com.eoi.grupo5.servicios;

import com.eoi.grupo5.modelos.Habitacion;
import com.eoi.grupo5.modelos.Precio;
import com.eoi.grupo5.repos.RepoHabitacion;
import com.eoi.grupo5.repos.RepoPrecio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicioHabitacion extends AbstractBusinessServiceSoloEnt<Habitacion, Integer, RepoHabitacion>{


    protected ServicioHabitacion(RepoHabitacion repoHabitacion) {
        super(repoHabitacion);
    }

    public Precio getPrecioActual(Habitacion habitacion, LocalDateTime fechaActual) {
        return habitacion.getPrecio().stream()
                .filter(precio -> !fechaActual.isBefore(precio.getFechaInicio()) && (precio.getFechaFin() == null || !fechaActual.isAfter(precio.getFechaFin())))
                .findFirst()
                .orElse(null);
    }

    public Double calcularPrecioTotal(Habitacion habitacion, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        double precioTotal = 0.0;
        LocalDateTime fechaActual = fechaInicio;

        while (!fechaActual.isAfter(fechaFin)) {
            Precio precioVigente = getPrecioActual(habitacion, fechaActual);
            if (precioVigente != null) {
                precioTotal += precioVigente.getPrecio();
            }
            // Avanzar al siguiente día
            fechaActual = fechaActual.plusDays(1);
        }

        return precioTotal;
    }
}
