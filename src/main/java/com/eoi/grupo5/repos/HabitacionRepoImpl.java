package com.eoi.grupo5.repos;

import com.eoi.grupo5.models.Habitacion;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class HabitacionRepoImpl implements Repo<Habitacion>{

    private EntityManager em;

    public HabitacionRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Habitacion> listar() {
        return em.createQuery("SELECT h FROM Habitacion h", Habitacion.class).getResultList();
    }

    @Override
    public Optional<Habitacion> porId(Integer id) {
        return Optional.ofNullable(em.find(Habitacion.class, id));
    }

    @Override
    public void guardar(Habitacion habitacion) {
        try {
            em.getTransaction().begin();
            if(habitacion.getId() != null && habitacion.getId() > 0) {
                em.merge(habitacion);
            } else {
                em.persist(habitacion);
            }
            em.getTransaction().commit();
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Integer id) {
        try {
            em.getTransaction().begin();
            Optional<Habitacion> usu= porId(id);
            if(usu.isPresent()) {
                em.remove(usu.get());
                em.getTransaction().commit();
            }
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }
}
