package com.eoi.grupo5.controladores;


import com.eoi.grupo5.servicios.ServicioUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    private final ServicioUsuario servicio;

    public UsuarioController(ServicioUsuario servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/inicio-sesion")
    public String inicioSesion(Model modelo) {
        return "login";
    }

    @GetMapping("/registro")
    public String registroUsuario(Model modelo) {
        return "register";
    }

}
