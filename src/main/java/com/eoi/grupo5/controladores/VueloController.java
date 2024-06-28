package com.eoi.grupo5.controladores;

import com.eoi.grupo5.servicios.ServicioVuelo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VueloController {

    private final ServicioVuelo servicio;

    public VueloController(ServicioVuelo servicio) {
        this.servicio = servicio;
    }

    @GetMapping("vuelos/lista")
    public String listaVuelos(Model modelo) {
        //List<Vuelo> vuelos = servicio.buscarEntidades();
        //modelo.addAttribute("lista", vuelos);
        return "vuelos";
    }

}
