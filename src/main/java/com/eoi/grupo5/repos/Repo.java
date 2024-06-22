package com.eoi.grupo5.repos;

import java.util.List;
import java.util.Optional;

public interface Repo<T>{

    List<T> listar();
    Optional<T> porId(Integer id);
    void guardar(T t);
    void eliminar(Integer id);
}
