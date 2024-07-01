package com.eoi.grupo5.controladores;

import com.eoi.grupo5.modelos.Vuelo;
import com.eoi.grupo5.servicios.ServicioVuelo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class VueloController {

    private final ServicioVuelo servicio;

    public VueloController(ServicioVuelo servicio) {
        this.servicio = servicio;
    }

    @GetMapping("vuelos/lista")
    public String listaVuelos(Model modelo) {
        List<Vuelo> vuelos = servicio.buscarEntidades();
        modelo.addAttribute("vuelos", vuelos);
        return "vuelos";
    }

    @GetMapping("/vuelo/{id}")
    public String detallesVuelo(Model modelo, @PathVariable Integer id) {
        Optional<Vuelo> vuelo = servicio.encuentraPorId(id);
        modelo.addAttribute("vuelo",vuelo);
        return "detallesVuelo";
    }

}
