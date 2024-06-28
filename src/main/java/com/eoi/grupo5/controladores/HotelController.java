package com.eoi.grupo5.controladores;

import com.eoi.grupo5.modelos.Hotel;
import com.eoi.grupo5.servicios.ServicioHotel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HotelController {

    private final ServicioHotel servicio;

    public HotelController(ServicioHotel servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/hoteles/lista")
    public String listaHoteles(Model modelo) {
        List<Hotel> hoteles = servicio.buscarEntidades();
        modelo.addAttribute(hoteles);
        return "hoteles";
    }

}
