package com.eoi.grupo5.servicios;


import com.eoi.grupo5.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface ServicioApp {
    List<Usuario> listaUsuario();
    Optional<Usuario> porId(Integer id);
    void guardar(Usuario usu);
    void eliminar(Integer id);
}
