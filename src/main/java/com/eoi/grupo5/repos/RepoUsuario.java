package com.eoi.grupo5.repos;

import com.eoi.grupo5.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUsuario extends JpaRepository<Usuario, Integer> {
}
