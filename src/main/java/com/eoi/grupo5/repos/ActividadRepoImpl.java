package com.eoi.grupo5.repos;

import com.eoi.grupo5.models.Actividad;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ActividadRepoImpl implements Repo<Actividad> {

    private EntityManager em;

    public ActividadRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Actividad> listar() {
        return  em.createQuery("SELECT a FROM Actividad a", Actividad.class).getResultList();
    }

    @Override
    public Optional<Actividad> porId(Integer id) {
        return Optional.ofNullable(em.find(Actividad.class, id));

    }

    @Override
    public void guardar(Actividad actividad) {
        try {
            em.getTransaction().begin();
            if(actividad.getId() != null && actividad.getId() > 0) {
                em.merge(actividad);
            } else {
                em.persist(actividad);
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
            Optional<Actividad> act= porId(id);
            if(act.isPresent()) {
                em.remove(act.get());
                em.getTransaction().commit();
            }
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
