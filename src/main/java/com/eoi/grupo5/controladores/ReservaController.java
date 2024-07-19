package com.eoi.grupo5.controladores;

import com.eoi.grupo5.modelos.Reserva;
import com.eoi.grupo5.modelos.Usuario;
import com.eoi.grupo5.repos.RepoUsuario;
import com.eoi.grupo5.servicios.ServicioReserva;
import com.eoi.grupo5.servicios.ServicioUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class ReservaController {

    private final ServicioReserva servicioReserva;
    private final RepoUsuario repoUsuario;

    public ReservaController(ServicioReserva servicioReserva, RepoUsuario repoUsuario) {
        this.servicioReserva = servicioReserva;
        this.repoUsuario = repoUsuario;
    }

    @PostMapping("/reservar/habitacion")
    public String crearReservaHabitacion(@RequestParam Integer idHabitacion,
                                         @RequestParam LocalDateTime fechaInicio,
                                         @RequestParam LocalDateTime fechaFin,
                                         Principal principal) {
        Optional<Usuario> optionalUsuario = repoUsuario.findByNombreUsuario(principal.getName());
        if (optionalUsuario.isPresent()){
            Usuario usuario = optionalUsuario.get();
            Reserva reserva = servicioReserva.crearReserva(usuario, fechaInicio,fechaFin);
            servicioReserva.addHabitacionToReserva(reserva, idHabitacion);
        }
        return "redirect:/reservas";
    }
}
