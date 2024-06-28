package com.eoi.grupo5.repos;

import com.eoi.grupo5.modelos.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoActividad extends JpaRepository<Actividad, Integer> {
}
