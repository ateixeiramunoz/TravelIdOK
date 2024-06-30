package com.eoi.grupo5.controladores;

import com.eoi.grupo5.modelos.Actividad;
import com.eoi.grupo5.servicios.ServicioActividad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ActividadController {

    private final ServicioActividad servicio;

    public ActividadController(ServicioActividad servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/actividades/lista")
    public String listaActividades(Model modelo) {
        List<Actividad> actividades = servicio.buscarEntidades();
        modelo.addAttribute("lista", actividades);
        return "actividades";
    }

}
