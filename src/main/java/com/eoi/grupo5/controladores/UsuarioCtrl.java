package com.eoi.grupo5.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UsuarioCtrl {

    @GetMapping("/inicio-sesion")
    public String iniciarSesion() {
        return "login";
    }

    @GetMapping("/registro-usuario")
    public String registrarse() {
        return "register";
    }
}
