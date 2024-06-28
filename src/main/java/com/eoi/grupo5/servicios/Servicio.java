package com.eoi.grupo5.servicios;

import java.util.List;
import java.util.Optional;

public interface Servicio<T> {
    List<T> listar();
    Optional<T> porId(Integer id);
    void guardar(T entity);
    void eliminar(T entity);
}
