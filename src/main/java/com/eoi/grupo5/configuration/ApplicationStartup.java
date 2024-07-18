package com.eoi.grupo5.configuration;

import com.eoi.grupo5.modelos.Usuario;
import com.eoi.grupo5.repos.RepoUsuario;
import com.eoi.grupo5.servicios.ServicioUsuario;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    private final RepoUsuario repoUsuario;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationStartup(RepoUsuario repoUsuario, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repoUsuario = repoUsuario;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        Usuario usuario = new Usuario();
        repoUsuario.save(usuario);
    }
}
