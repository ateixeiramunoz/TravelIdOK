package com.eoi.grupo5.controladores;

import com.eoi.grupo5.modelos.Hotel;
import com.eoi.grupo5.servicios.ServicioHotel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class HotelController {

    private final ServicioHotel servicio;

    public HotelController(ServicioHotel servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/hoteles/lista")
    public String listaHoteles(Model modelo) {
        List<Hotel> hoteles = servicio.buscarEntidades();
        modelo.addAttribute("hoteles",hoteles);
        return "hoteles";
    }

    @GetMapping("/hotel/{id}")
    public String detallesHotel(Model modelo, @PathVariable Integer id) {
        Optional<Hotel> hotel = servicio.encuentraPorId(id);
        modelo.addAttribute("hotel",hotel);
        modelo.addAttribute("recomendados", servicio.obtenerHotelesEnTuZona(hotel));
        return "detallesHotel";
    }



}
