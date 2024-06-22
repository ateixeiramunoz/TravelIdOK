package com.eoi.grupo5;

import com.eoi.grupo5.models.*;
import com.eoi.grupo5.servicios.ServicioApp;
import com.eoi.grupo5.servicios.ServicioAppImpl;
import com.eoi.grupo5.util.JpaUtil;
import jakarta.persistence.EntityManager;


public class MainPrueba {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntitymanager();

        ServicioApp srvcApp = new ServicioAppImpl(em);

        System.out.println("================= Creamos un nuevo Usuario =================");
        Usuario usu = new Usuario("Pepito", "pepito123");
        srvcApp.guardarUsuario(usu);
        System.out.println(usu);
        System.out.println("================= Buscamos un Usuario =================");
        System.out.println(srvcApp.usuarioporId(1));

    }
}
