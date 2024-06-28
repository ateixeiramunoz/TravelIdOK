package com.eoi.grupo5.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vuelos")
public class VueloCtrl {

    @GetMapping
    public String vuelos() {
        return "vuelos";
    }
}
